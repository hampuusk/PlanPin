package se.planpin.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StatFs;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

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
