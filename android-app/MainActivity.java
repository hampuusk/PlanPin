package se.planpin.app;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * PlanPin's only own Android code (patch-android.mjs puts it in place of Capacitor's empty MainActivity).
 * It does three small things the web part cannot do itself:
 *
 * 1. A file sent with "Dela → PlanPin" arrives in another shape (SEND, the file as an extra) than a file opened in
 *    the file manager (VIEW, the file as the address). It is handed on as opened, so the web part gets both the same
 *    way (the event appUrlOpen, see src/js/46-oppnat-utifran.js). Nothing is read here; only the address is passed,
 *    and an intent that carries something else than one address is left as it came.
 *
 * 2. When Android brings the app back after having closed it in the background, it hands over the file or link the
 *    app was once started with one more time. That is dropped, so nothing is read in twice.
 *
 * 3. It says how much room is left on the phone (the plugin Phone below), for the storage meter under Säkerhet och
 *    lagring. Two numbers are read from the phone and handed to the web part; nothing is written and nothing sent.
 *
 * 4. For Diagnosverktyg (V1.7.21): the phone's memory (free, total, whether Android finds it low) and the app's own
 *    use, and why the app ended the last times (Android 11 and newer: by the user, a crash, for lack of memory…).
 *    Only numbers and Android's own words for the reason; read on request, kept nowhere, sent nowhere.
 *
 * 5. For Självtest (V1.7.39): the battery's temperature (apps cannot read the processor's own; the battery follows it),
 *    Android's heat level and how close it is to slowing the phone down, and the processor time this app's own
 *    process has used. Numbers only, read on request every few seconds during the test, kept nowhere, sent nowhere.
 *
 * 6. For photos (V1.8.2): a photo made smaller here, with Android's own JPEG reader – it can read a photo at a half, a
 *    quarter or an eighth of its size straight away. The photo comes from the web part and goes back to it as text,
 *    inside the phone and in memory only: no file is opened or written, nothing is kept and nothing is sent anywhere.
 *    Used by Självtest to compare it with the web part's own way; the photos use it only once it has proved faster.
 *
 * 7. For Diagnosverktyg (V1.8.44): the phone as Android describes it – its model and Android version, the app as it is
 *    installed (version, when, which permissions it has, whether it is built for fault-finding or for Android's cloud
 *    backup), the WebView that draws the app, the settings that change how the app looks and runs (text size, display
 *    size, dark mode, battery saver, background limits), what vibrating takes (a vibrator, the sound mode), and how
 *    long the app's process has run. And of each time the app ended: which of its processes, and how. Android's own
 *    words and numbers only – no accounts, no ids of the phone or the user, no files; read on request, kept nowhere,
 *    sent nowhere.
 */
public class MainActivity extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        boolean again =
            savedInstanceState != null ||
            (intent != null && (intent.getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) != 0);
        if (again) setIntent(new Intent(Intent.ACTION_MAIN));
        registerPlugin(Phone.class); // before Capacitor starts, as its documentation says
        super.onCreate(savedInstanceState);
    }

    /** The free and the total room, in bytes, of the storage the app's own data is kept in. */
    @CapacitorPlugin(name = "Phone")
    public static class Phone extends Plugin {

        @PluginMethod
        public void room(PluginCall call) {
            try {
                StatFs s = new StatFs(getContext().getFilesDir().getAbsolutePath());
                JSObject r = new JSObject();
                r.put("free", s.getAvailableBytes());
                r.put("total", s.getTotalBytes());
                call.resolve(r);
            } catch (RuntimeException e) {
                call.reject("unavailable"); // the web part then shows the meter without the phone's room
            }
        }

        /** The phone's memory and the app's own use of it, in bytes (pss: what the app holds, shared parts split). */
        @PluginMethod
        public void memory(PluginCall call) {
            try {
                ActivityManager am = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
                ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
                am.getMemoryInfo(mi);
                Debug.MemoryInfo dm = new Debug.MemoryInfo();
                Debug.getMemoryInfo(dm);
                JSObject r = new JSObject();
                r.put("avail", mi.availMem);
                r.put("total", mi.totalMem);
                r.put("low", mi.lowMemory);
                r.put("threshold", mi.threshold);
                r.put("pss", (long) dm.getTotalPss() * 1024L);
                r.put("classMb", am.getMemoryClass());
                r.put("largeClassMb", am.getLargeMemoryClass());
                call.resolve(r);
            } catch (RuntimeException e) {
                call.reject("unavailable");
            }
        }

        /** Why the app's process ended the last times (newest first), as Android recorded it. Android 11 and newer. */
        @PluginMethod
        public void exits(PluginCall call) {
            JSArray list = new JSArray();
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    ActivityManager am = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
                    String pkg = getContext().getPackageName();
                    for (ApplicationExitInfo x : am.getHistoricalProcessExitReasons(pkg, 0, 10)) {
                        JSObject o = new JSObject();
                        o.put("t", x.getTimestamp());
                        o.put("reason", x.getReason());
                        o.put("importance", x.getImportance());
                        o.put("pss", x.getPss() * 1024L);
                        // V1.8.44: also what it held in all (rss), how it ended (the exit code or the signal) and which
                        // of the app's processes it was – empty for the app itself, else what follows the app's name
                        o.put("rss", x.getRss() * 1024L);
                        o.put("status", x.getStatus());
                        String pn = x.getProcessName();
                        if (pn == null || pn.equals(pkg)) pn = "";
                        else if (pn.startsWith(pkg)) pn = pn.substring(pkg.length());
                        o.put("proc", pn.length() > 60 ? pn.substring(0, 60) : pn);
                        String d = x.getDescription();
                        o.put("desc", d == null ? "" : d.length() > 120 ? d.substring(0, 120) : d);
                        list.put(o);
                    }
                }
                JSObject r = new JSObject();
                r.put("api", Build.VERSION.SDK_INT);
                r.put("list", list);
                call.resolve(r);
            } catch (RuntimeException e) {
                call.reject("unavailable");
            }
        }

        /** The phone's warmth and the app's processor time, for Självtest. Whole numbers only: tenths of a degree,
         *  thousandths of the heat margin (1000 = Android starts to slow the phone down), milliseconds. */
        @PluginMethod
        public void vitals(PluginCall call) {
            try {
                Context c = getContext();
                JSObject r = new JSObject();
                Intent b = c.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED)); // the latest, nothing registered
                if (b != null) {
                    r.put("tempTenths", b.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -10000));
                    r.put("level", b.getIntExtra(BatteryManager.EXTRA_LEVEL, -1));
                    r.put("scale", b.getIntExtra(BatteryManager.EXTRA_SCALE, -1));
                    r.put("plugged", b.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0) != 0);
                }
                PowerManager pm = (PowerManager) c.getSystemService(Context.POWER_SERVICE);
                if (pm != null && Build.VERSION.SDK_INT >= 29) r.put("thermal", pm.getCurrentThermalStatus());
                if (pm != null && Build.VERSION.SDK_INT >= 30) {
                    float hr = pm.getThermalHeadroom(10);
                    if (!Float.isNaN(hr)) r.put("headroomMilli", Math.round(hr * 1000));
                }
                r.put("cpuMs", Process.getElapsedCpuTime());
                call.resolve(r);
            } catch (RuntimeException e) {
                call.reject("unavailable");
            }
        }

        /** The phone as Android describes it, for Diagnosverktyg (V1.8.44; see 7 at the top). Whole numbers, yes/no and
         *  Android's own short words: fontMilli is the phone's text size in thousandths (1000 = normal), dpi the
         *  screen's density now and dpiStable as the phone is made (their ratio is the display size setting), perms
         *  the permissions the app has asked for by their last word, with + after the ones it has been given, and
         *  procMs how long the app's process has run. */
        @PluginMethod
        @SuppressWarnings("deprecation") // the older ways to ask about the app's own package, its build number and the vibrator: the same on every Android the app runs on
        public void device(PluginCall call) {
            try {
                Context c = getContext();
                JSObject r = new JSObject();
                r.put("maker", Build.MANUFACTURER);
                r.put("model", Build.MODEL);
                r.put("android", Build.VERSION.RELEASE);
                r.put("api", Build.VERSION.SDK_INT);
                if (Build.VERSION.SDK_INT >= 23) r.put("patch", Build.VERSION.SECURITY_PATCH);
                if (Build.VERSION.SDK_INT >= 31) r.put("soc", Build.SOC_MODEL);
                if (Build.SUPPORTED_ABIS != null && Build.SUPPORTED_ABIS.length > 0) r.put("abi", Build.SUPPORTED_ABIS[0]);
                try {
                    PackageInfo pi = c.getPackageManager().getPackageInfo(c.getPackageName(), PackageManager.GET_PERMISSIONS);
                    r.put("app", pi.versionName);
                    r.put("build", Build.VERSION.SDK_INT >= 28 ? pi.getLongVersionCode() : (long) pi.versionCode);
                    r.put("first", pi.firstInstallTime);
                    r.put("updated", pi.lastUpdateTime);
                    JSArray perms = new JSArray();
                    String[] asked = pi.requestedPermissions;
                    int[] flags = pi.requestedPermissionsFlags;
                    for (int i = 0; asked != null && i < asked.length; i++) {
                        boolean given = flags != null && i < flags.length && (flags[i] & PackageInfo.REQUESTED_PERMISSION_GRANTED) != 0;
                        perms.put(asked[i].substring(asked[i].lastIndexOf('.') + 1) + (given ? "+" : ""));
                    }
                    r.put("perms", perms);
                } catch (PackageManager.NameNotFoundException e) {
                    r.put("app", ""); // the app's own package is always there; the web part shows the rest without it
                }
                ApplicationInfo ai = c.getApplicationInfo();
                r.put("target", ai.targetSdkVersion);
                r.put("debug", (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0);
                r.put("backup", (ai.flags & ApplicationInfo.FLAG_ALLOW_BACKUP) != 0);
                if (Build.VERSION.SDK_INT >= 26) {
                    PackageInfo wv = WebView.getCurrentWebViewPackage();
                    if (wv != null) {
                        r.put("wv", wv.packageName);
                        r.put("wvVer", wv.versionName);
                    }
                }
                Configuration cf = c.getResources().getConfiguration();
                r.put("fontMilli", Math.round(cf.fontScale * 1000f));
                r.put("night", (cf.uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES);
                r.put("dpi", c.getResources().getDisplayMetrics().densityDpi);
                if (Build.VERSION.SDK_INT >= 24) r.put("dpiStable", DisplayMetrics.DENSITY_DEVICE_STABLE);
                PowerManager pm = (PowerManager) c.getSystemService(Context.POWER_SERVICE);
                if (pm != null) {
                    r.put("powerSave", pm.isPowerSaveMode());
                    if (Build.VERSION.SDK_INT >= 23) r.put("battOpt", pm.isIgnoringBatteryOptimizations(c.getPackageName()));
                }
                ActivityManager am = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);
                if (am != null) {
                    r.put("lowRam", am.isLowRamDevice());
                    if (Build.VERSION.SDK_INT >= 28) r.put("bgRestricted", am.isBackgroundRestricted());
                }
                Vibrator vb = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
                r.put("vibrator", vb != null && vb.hasVibrator());
                AudioManager au = (AudioManager) c.getSystemService(Context.AUDIO_SERVICE);
                if (au != null) r.put("ringer", au.getRingerMode()); // 0 silent, 1 vibrate, 2 with sound
                if (Build.VERSION.SDK_INT >= 24) r.put("procMs", SystemClock.uptimeMillis() - Process.getStartUptimeMillis());
                call.resolve(r);
            } catch (RuntimeException e) {
                call.reject("unavailable");
            }
        }

        /** A JPEG photo made at most max pixels on its long side, turned the way the camera said, packed as a JPEG of
         *  quality q (the same as the web part: 1500 px, 80). In and out as base64 text; ms is the time taken here. */
        @PluginMethod
        public void shrinkPhoto(PluginCall call) {
            String data = call.getString("data");
            int max = call.getInt("max", 1500);
            int q = call.getInt("q", 80);
            if (data == null || max < 16 || q < 10 || q > 100) {
                call.reject("bad input");
                return;
            }
            long t0 = System.nanoTime();
            Bitmap bmp = null;
            Bitmap out = null;
            try {
                byte[] in = Base64.decode(data, Base64.DEFAULT);
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(in, 0, in.length, o);
                if (o.outWidth <= 0 || o.outHeight <= 0) {
                    call.reject("not a photo");
                    return;
                }
                int ori = ExifInterface.ORIENTATION_NORMAL;
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        ori = new ExifInterface(new ByteArrayInputStream(in)).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                    } catch (IOException e) {
                        ori = ExifInterface.ORIENTATION_NORMAL; // no readable turn: as it is
                    }
                }
                int side = Math.max(o.outWidth, o.outHeight), sample = 1;
                while (side / (sample * 2) >= max) sample *= 2; // read at a half, a quarter… but never smaller than wanted
                BitmapFactory.Options r2 = new BitmapFactory.Options();
                r2.inSampleSize = sample;
                bmp = BitmapFactory.decodeByteArray(in, 0, in.length, r2);
                if (bmp == null) {
                    call.reject("not a photo");
                    return;
                }
                float k = Math.min(1f, (float) max / Math.max(bmp.getWidth(), bmp.getHeight()));
                Matrix m = new Matrix();
                m.setScale(k, k);
                switch (ori) {
                    case ExifInterface.ORIENTATION_FLIP_HORIZONTAL: m.postScale(-1, 1); break;
                    case ExifInterface.ORIENTATION_ROTATE_180: m.postRotate(180); break;
                    case ExifInterface.ORIENTATION_FLIP_VERTICAL: m.postScale(1, -1); break;
                    case ExifInterface.ORIENTATION_TRANSPOSE: m.postRotate(90); m.postScale(-1, 1); break;
                    case ExifInterface.ORIENTATION_ROTATE_90: m.postRotate(90); break;
                    case ExifInterface.ORIENTATION_TRANSVERSE: m.postRotate(-90); m.postScale(-1, 1); break;
                    case ExifInterface.ORIENTATION_ROTATE_270: m.postRotate(-90); break;
                    default: break;
                }
                out = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), m, true);
                ByteArrayOutputStream jpg = new ByteArrayOutputStream();
                if (!out.compress(Bitmap.CompressFormat.JPEG, q, jpg)) {
                    call.reject("could not pack");
                    return;
                }
                JSObject r = new JSObject();
                r.put("data", Base64.encodeToString(jpg.toByteArray(), Base64.NO_WRAP));
                r.put("w", out.getWidth());
                r.put("h", out.getHeight());
                r.put("ms", (System.nanoTime() - t0) / 1000000L);
                call.resolve(r);
            } catch (RuntimeException | OutOfMemoryError e) {
                call.reject("could not make smaller");
            } finally {
                if (out != null && out != bmp) out.recycle();
                if (bmp != null) bmp.recycle();
            }
        }
    }

    // Capacitor passes every intent through here – also the one the app was started with (BridgeActivity.load)
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(opened(intent));
    }

    @SuppressWarnings("deprecation")
    private static Intent opened(Intent intent) {
        if (intent == null || !Intent.ACTION_SEND.equals(intent.getAction())) return intent;
        Parcelable file;
        try {
            file = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        } catch (RuntimeException e) {
            return intent; // extras from another app that cannot be read
        }
        if (!(file instanceof Uri)) return intent;
        Intent view = new Intent(intent);
        view.setAction(Intent.ACTION_VIEW);
        view.setDataAndType((Uri) file, intent.getType());
        return view;
    }
}
