# Nyheter och fixar efter uppdatering

Vad som är nytt eller ändrat i varje version som laddats upp till GitHub, nyaste först. Versionsnumret syns längst ner under Inställningar i appen.

---

## V1.8 – kommande (ännu inte uppladdad)

Inga ändringar än.

---

## V1.7 (2026-11-15)

Samlar ändringarna från V1.6.1–V1.6.41.

**Viktigt vid uppdatering**
- **Från V1.6:** installera som vanligt, uppdragen ligger kvar.
- **Från V1.5:** V1.7 flyttar inte längre över det V1.5 sparade i telefonen och läser inte V1.5:s säkerhetskopior. Uppdatera först till V1.6, öppna appen en gång så att uppdragen flyttas, och uppdatera sedan till V1.7. Säkerhetskopior gjorda i V1.6 och senare läses in som förut.

**Nytt**
- **Markera ritningshuvud och byggnad.** Under Ritningsinställningar → Markerade områden drar du en ruta över ritningshuvudet och, om du vill, runt byggnaden. Rutan sparas inte när du släpper: den får ett handtag i varje hörn, så du kan dra i hörnen för att ändra storleken och i rutan för att flytta den, och trycker Klar när den sitter rätt. Ändra öppnar en sparad ruta på samma sätt, och Avbryt lämnar den som den var. Symbolförteckningen läggs i ritningshuvudet – den fyller det, och om det är för litet går den utanför i stället för att bli svårläst, men aldrig över byggnaden. Är ritningshuvudet minst dubbelt så brett som högt (längs över- eller underkanten) står uppdragsuppgifterna alltid i en egen spalt bredvid listan, och listan delas i så få spalter som behövs för att få plats. Mellan spalterna är det alltid minst 1 cm fritt. Mycket långa ord, som en länk, bryts i stället för att gå utanför rutan. Lägesbildernas översikt visar byggnaden i stället för hela arket. Det som är markerat används alltid i exporten; utan markeringar placeras allt automatiskt som förut.
- **Tydligare lägesbilder i exporten.** Numret ligger inte längre ovanpå det det pekar ut: en liten prick sitter exakt på platsen och numret står bredvid med en hänvisningslinje, likadant som på översiktsritningarna. Översikten i hörnet är ett vitt kort med ritningens namn där hela ritningen syns skarpt, utsnittet är inramat och objektet är en prick i sin färg.
- **Skanna QR-koden utan att ta en bild.** När medhjälparen läser in uppdraget första gången visar Skanna QR-koden kameran som en sökare, och koden läses så fort den syns – inget att trycka på. På telefoner med flera kameror på baksidan väljer sökaren huvudkameran (annars ger telefonen gärna vidvinkeln, där koden blir för liten). Där kameran inte kan visas som sökare finns Fota QR-koden kvar, och koden kan alltid skrivas in. Kan telefonen inte läsa QR-koder alls visas bara kodfältet.
- **Android: öppna filer direkt i PlanPin.** Tryck på ett delat uppdrag eller en säkerhetskopia i filhanteraren, eller välj Dela → PlanPin, så öppnas appen och filen läses in – du behöver inte leta upp den med Läs in säkerhetskopia. Android känner inte till filsorten, så PlanPin erbjuds för zip-filer och filer av okänd sort; är det inte en fil från PlanPin säger appen det och inget händer. En okrypterad säkerhetskopia läses in först när du har svarat ja; en krypterad frågar efter sitt lösenord som vanligt.
- **Android: telefonens egen kamera kan läsa QR-koden.** QR-koden bär nu en länk (planpin://samarbeta/…). Läser telefonens kamera den öppnas PlanPin med koden ifylld. Fil och kod kan komma i vilken ordning som helst: koden väntar på filen (högst en kvart) och tvärtom. Alla telefoners kameror öppnar inte sådana länkar – sökaren i appen fungerar alltid.

- **Kopiera en symbol på ritningen.** Tryck på en utplacerad symbol och välj "Kopiera" (ikonen med två papper). Varje tryck på ritningen sätter sedan ut en likadan symbol med samma riktning, tills du trycker "Klar". Ångra tar bort den senaste kopian.
- **Senast använda symboler överst.** De fyra symboler du senast satte ut står överst i symbollistan, nyast först, med ett streck som skiljer dem från resten. Listan sparas och finns kvar nästa gång.

**Nytt: automatisk säkerhetskopia**
- **Android: kopia av uppdraget du arbetar i.** När du har ändrat något sparas en kopia av uppdraget, högst var tionde minut och när du lämnar appen, i Dokument/PlanPin/Autokopior. Varje uppdrag har en fil som skrivs över, så bara den senaste kopian finns kvar. Om appen kraschar eller telefonens data försvinner läser du in kopian med Läs in säkerhetskopia på startsidan.
- **Samma PIN-kod som appen.** Har du PIN-kod på krypteras kopian med den, så det finns ingen extra kod att komma ihåg. Utan PIN-kod sparas kopian okrypterad. Filen heter alltid som uppdraget, så den är lätt att hitta.
- **Ritningarna följer med, inte fotona.** Fotona finns kvar i appen, och i mobilens bilder om "Spara foton i mobilen" är på. Vill du ha med fotona gör du en vanlig säkerhetskopia.
- **Inställningar → Säkerhet och lagring → Säkerhetskopia.** Där stänger du av och slår på den automatiska kopian och ser när de senaste kopiorna sparades. Radera allt tar bort kopiorna också.
- **Webbappen påminner varje timme.** Har du en ändring som inte är säkerhetskopierad och det har gått en timme sedan den gjordes, frågar appen om du vill säkerhetskopiera – var du än är i appen, men aldrig mitt i något du gör. "Inte nu" frågar igen om en timme. Valet heter "Påminn om säkerhetskopiering" och finns under Inställningar → Säkerhet och lagring.

**Nytt: brandcellsgränser**
- **Rita brandcellsgränser i symbolverktyget.** Brandcellsgräns finns direkt efter Anteckning i ISO-listan. Den ritas som väggar: dra en linje i taget, linjerna hänger ihop tills du trycker på den gröna bocken, och hörnen kan flyttas efteråt.
- **Klass och tid.** I rutan med val finns två rullistor: en för brandteknisk klass (EI, EW eller E) som visar klassens streck, och en för tid (15–360 minuter) som visar tidens färg. Tiden ger färgen och klassen strecken: EI har tre korta streck, EW två och E ett. Väljer du en ritad gräns ändras hela den. Ditt senaste val finns kvar till nästa gång.
- **Exakt 1 mm i exporten.** Brandcellsgränserna är alltid 1 mm breda på den utskrivna ritningen. På skärmen blir de aldrig tunnare än att de syns.
- **Alltid med på översiktsritningarna.** Brandcellsgränserna finns på alla översiktsritningar: varje grupps ritning och mätningarnas ritning. Valet "Symboler visas på" styr bara symbolerna och anteckningarna.
- **Förteckning och Excel.** Symbolförteckningen får en rad per sort som används, till exempel en röd linje med tre korta streck för EI 60. Excel får en flik med antal meter per klass och tid, totalt och per ritning.

**Rättat**
- **Långa namn kortades när en säkerhetskopia lästes in.** Fälten för uppdragsnamn, ritningens namn, uppdragsnummer och kontrollant tog emot hur lång text som helst, men det som var längre än 120 tecken (uppdragsnamn), 80 (ritningens namn och kontrollant) eller 60 (uppdragsnummer) kom tillbaka avkortat från en säkerhetskopia eller ett delat uppdrag. Nu tar fälten emot precis så mycket som kommer tillbaka.
- **Android: den automatiska kopians filnamn kunde sluta mitt i en emoji** när ett långt uppdragsnamn hade en emoji just där namnet kortas. Namn och texter kortas nu aldrig mitt i ett tecken.
- **Objektlistan ryms på smala telefoner.** På en smal skärm skars krysset som stänger listan av i kanten, liksom Klar, Kategori och Radera i Välj-läget, och valet mellan den här ritningen och alla gick ur sin ruta. Listan är nu aldrig smalare än att allt får plats. Har telefonen stor text flyttar knapparna ner en rad i stället för att kapas, och på en liten skärm släpper sökraden och rubriken taget när du rullar, så att objekten alltid syns.
- **Checklistans knappar.** Knappen som raderar en checkpunkt låg kloss mot ramen bredvid "Flytta". Varje knapp är nu så bred som sitt ord.
- **Brandcellsgränser håller sin tjocklek.** Linjen blev dubbelt så tjock när objektlistan stängdes, och tunn som ett hårstrå medan listan var öppen eller när du zoomade ut, tills ritningen ritades om. Nu följer den zoomen direkt: 1 mm på pappret, aldrig tunnare än att den syns.
- **Förstoringsglaset blinkar inte vid snabba tryck.** Det kommer först när fingret har legat kvar en kort stund (under en femtedels sekund) och tonar mjukt in; ett snabbt tryck för att placera eller välja en symbol visar det inte alls. När det väl syns följer det fingret direkt som förut.
- **Prickarna blinkar inte längre.** Täta objekt som visas som prickar blinkade till (blev nummer en kort stund och krympte sedan igen) varje gång ritningen ritades om – när du bytte eller placerade en symbol, öppnade pennan, Mät, inställningar eller objektlistan. Nu ritas de direkt som de ska vara, även inzoomat och när ett objekt är markerat i listan.
- **Rutor som dras ner med musen (på dator).** När en ruta hade dragits ner med musen kunde nästa ruta fastna en bit ner när den drogs, och trycket efteråt gjorde ingenting: draget hade markerat text på sidan, och webbläsaren drog då den markerade texten i stället för rutan. Ett drag i rutans överkant markerar inte längre någon text. På telefon, där man sveper med fingret, fanns felet inte.

**Ändrat: ritning i stället för plan**
- **Det som hette plan heter ritning.** En flik i ett uppdrag behöver inte vara ett våningsplan – det kan lika gärna vara en annan byggnad, en fasad eller en detalj – så appen säger ritning överallt: "+ Ny ritning", "Ritningsinställningar", "Radera ritningen" och "3 ritningar" på uppdragskortet. En ritning som lämnas utan namn heter "Ritning 1", "Ritning 2" och så vidare. Ritningarna du redan har behåller sina namn.
- **Filen eller bilden som ritningen visar heter underlag.** När du lägger till en ritning väljer du "Med underlag" eller "Utan underlag", och sidan under Ritningsinställningar där filnamnet står och där du byter fil heter "Underlag", med knappen "Byt underlag". "Placera på ritning" och "Tryck på ritningen" heter som förut.
- **"Denna" och "Alla"** väljer i objektlistan mellan den här ritningens objekt och alla ritningars (förut "Detta plan" och "Alla plan"). Ritningens namn under rubriken "Objekt" står som du har skrivit det, inte längre i versaler.
- **Exporten säger också ritning:** kolumnen i Excel heter "Ritning".

**Ändrat: samma ord och samma knappar överallt**
- **Radera heter Radera.** Checkpunkter, loggan och markerade områden hade "Ta bort". Nu heter knappen Radera, har röd text som alla andra Radera och frågar först – också för ett markerat område, som förut försvann direkt.
- **Säkerhetskopiera och Läs in säkerhetskopia.** Knapparna heter likadant på startsidan och under Säkerhet och lagring (förut "Gör säkerhetskopia", "Återställ" och "Läs in fil"). Läs in säkerhetskopia läser också in delade uppdrag, precis som förut. I rutan där du väljer lösenord heter knappen "Spara med lösenord" i stället för "Kryptera".
- **Grupper, + Ny checkpunkt, + Ny snabbtext, Accentfärg.** "Redigera grupper" heter "Grupper", "+ Lägg till …" heter "+ Ny …" som för grupper och kategorier, och under Utseende heter valen "Ljust eller mörkt" och "Accentfärg" (förut Tema och Färgtema).
- **Kortare frågor.** "Radera objekt 1?" i stället för "Är du säker att du vill radera objekt 1?", och texten under lovar inte längre att något raderas "för gott" när det går att ångra.
- **Radera uppdraget står sist i Uppdragsinställningar**, ensam på sin rad – som Radera ritningen i Ritningsinställningar. Sidan med säkerhetskopian heter "Säkerhetskopia". I menyn som kommer när du håller inne på ett uppdrag står Redigera, och Radera under den.
- **En röd knapp ser likadan ut överallt:** röd text och vanlig ram. Krysset som stänger objektlistan är inte längre rött – det raderar ingenting.
- **Avbryt bara där något kan gå förlorat.** Rutor där du bara väljer (Uppdragstyp, med eller utan underlag, Ny ritning, Byt grupp, kategori eller prioritering, pappersformat, menyn på ett uppdrag) har ingen Avbryt: du stänger dem med ett tryck utanför, ett svep nedåt eller bakåtknappen. Från "Ny inventering" går du tillbaka med "‹ Uppdragstyp" överst, och Byt kod och Stäng av PIN-kod har "‹ Säkerhet och lagring" överst i stället för en Tillbaka-knapp. Klar i kalibreringsraden har samma färg som alla andra Klar.
- **Den färdiga filen stängs bara med Stäng.** Rutan som kommer när en export eller en säkerhetskopia är klar går inte längre att svepa bort eller stänga med ett tryck utanför, eftersom filen försvinner när rutan stängs. Stäng frågar först: "Exporten avbryts och filen försvinner när du stänger. Är du säker?"
- **Uppdragsinformation sparas av sig själv** när du lämnar sidan, som ritningens namn. Knappen "Spara uppgifter" är borta – förut försvann det du hade skrivit om du stängde rutan utan att trycka på den.
- **Checklistan före exporten visas bara när något återstår.** Är allt avbockat kommer du direkt till exporten.
- **Allt du trycker på svarar.** Knappar, rader, flikar och länkar sjunker in eller mörknar medan fingret ligger på dem, och webbläsarens egen grå blink är borta.
- **Inga tomma rutor.** Ett objekt utan foto visar ingen ruta med "Inga foton än", objekt utan foto har ingen tom bildruta i listan, och "Inga snabbtexter än." står som vanlig text utan ram.
- **Småsaker:** valen för symbolstorlek fyller sin rad, "Ingen" ser likadan ut när du byter grupp eller kategori för flera objekt, uppdragskorten säger "objekt" med hela ordet och bryter inte raden mitt i "3 ritningar", knappen "Läs in säkerhetskopia" får alltid plats på en rad, loggans format heter JPEG, och versionen står som "PlanPin V1.6.x" överallt.

**Ändrat: rutor som står still och knappar inom räckhåll**
- **Rutan står still när du går mellan en meny och dess sidor.** I Uppdragsinställningar, Ritningsinställningar, Inställningar och exporten byts bara innehållet: rutan glider inte in på nytt och krymper inte, så länken tillbaka står där rubriken stod. Väljer du något på en sida som ritas om – en förvald grupp, ljust eller mörkt – ligger sidan kvar där du hade rullat i stället för att hoppa till toppen.
- **Rutan glider ner när den stängs**, hur du än stänger den: tryck utanför, bakåtknappen, Avbryt eller Spara. Förut gled den bara när du svepte ner den och försvann annars tvärt.
- **Besked visas ovanför rutan.** När en ruta är öppen ligger besked som "Uppgifterna är sparade" ovanför rutan i stället för över dess rader och knappar, och följer med ner när rutan stängs. Ett kort besked bryts inte längre i två rader på en smal telefon.
- **Exportera:** först det som saknas och valen för vad som ska med, och PDF, Word och Excel står fast i rutans nederkant så att de alltid är inom räckhåll. Avbryt är borta – rutan stängs med ett tryck utanför, ett svep eller bakåtknappen – liksom knappen "Tillbaka till exporten" under listan över det som saknas (länken överst finns kvar).
- **Knappar som står fast i nederkanten** (Spara i objektrutan, PDF, Word och Excel i exporten) går ända ner till rutans kant. Förut rullade innehållet förbi i en remsa under dem.
- **Ritningsinställningar och Uppdragsinställningar står i namnraden** också när ritningen har ett underlag, på samma plats som på en ritning utan underlag. I marginalen finns bara listan, ISO, Mät och pennan, så mindre av ritningen täcks.
- **Ritningsflikarna:** den valda fliken rullas alltid in så att den syns hel med en skymt av grannen, raden står kvar där du rullade den i stället för att hoppa tillbaka till början, och den tonar ut i kanten när det finns fler flikar åt det hållet.
- **Lagringsmätaren visar hur fullt det är.** Överst en stapel för hur mycket som används – i Android-appen mätt mot telefonens lediga utrymme ("600 MB använt · 23,4 GB ledigt på telefonen"), i webbappen mot 5 GB – och under den fördelningen mellan uppdragen, så att det syns vilket uppdrag som är störst. Stapeln blir röd när mindre än en femtedel är kvar. Förut var Android-appens stapel alltid full. För det här har Android-appen fått en liten egen del som läser två tal från telefonen (ledigt och totalt utrymme); den läser inget annat, skriver inget och skickar inget.

**Ändrat**
- **Ett Klar i Välj-läget.** I objektlistan bredvid ritningen fanns två Klar. Nu försvinner knappen Välj medan du väljer, och Klar står nere bredvid Alla – på samma ställe som i listan på en ritning utan underlag.
- **Sökfältet i objektlistan heter "Sök".** Hela texten fick inte plats i den smala listan. Raden med grupper och kategorier tonar ut i kanten när det finns fler att rulla till, i stället för att sluta i en halv knapp.
- **Förstoringsglaset visar symbolen.** När du lägger ut eller flyttar en symbol visar förstoringsglaset själva symbolen i rätt storlek och riktning, lite genomskinlig i en tunn orange ram, i stället för ett kryss – så du ser exakt var den hamnar, till exempel jäms med en vägg. Symboler som redan ligger där syns också i förstoringsglaset.
- **Förstoringsglaset anpassar sig efter symbolen.** När du lägger ut eller flyttar en symbol förstorar glaset aldrig mer än att symbolen tar knappt halva glaset, så du ser alltid vad som finns runt om – även när ritningen är inzoomad (förut fyllde symbolen glaset eller blev större än det). Är ritningen så inzoomad att glaset knappt skulle förstora alls visas det inte. När du flyttar en symbol ligger den alltid mitt i glaset, var på symbolen du än tog tag.
- **Symbolkolumnen rullar.** Pilarna upp och ner i ISO är borta; när alla symboler inte får plats rullar du kolumnen med fingret (eller mushjulet). Kolumnen står kvar där du lämnade den när du väljer en symbol, och en markerad symbol rullas fram så att den syns. Ett svep i kolumnen flyttar aldrig ritningen. Rutan med Klar, Gör om, Ångra och symbolens riktningar står alltid i kolumnen bredvid, med underkanten i nivå med symbolkolumnens, så den hoppar inte längre mellan under och bredvid.
- **Klass och Tid för brandcellsgränser.** Ett tryck på klassen eller tiden öppnar en liten kolumn bredvid verktygen, i samma stil, i stället för en stor lista över hela skärmen. Varje val visar sitt streckmönster eller sin färg; den valda är markerad. Ett tryck bredvid, på samma knapp igen eller mobilens bakåtknapp stänger kolumnen utan att något ritas. Kolumnen går aldrig ovanför eller under kolumnen den öppnas från; får inte alla tider plats rullar den.
- **Skala i rätt ordning.** Knappen Skala (i Mät) öppnar rutan Skala direkt, där du väljer skala och pappersformat. Raden ovanför ritningen visas bara när du väljer "Kalibrera med en känd längd" och har bara knappen Klar, som tar dig tillbaka till rutan Skala – liksom mobilens bakåtknapp och när en kalibrering är sparad. Skala och pappersformat står under varandra på smal skärm, så "Välj pappersformat" inte klipps.
- **Inga Stäng-knappar i inställningarna.** Appinställningar, Uppdragsinställningar, Ritningsinställningar och Skala stängs som allt annat: tillbaka-länken överst, svep ner, tryck utanför rutan eller mobilens bakåtknapp. Ett ändrat namn på ritningen sparas fortfarande när rutan stängs, och Radera ritningen tar nu hela bredden.
- **Säkerhet och lagring samlar allt på ett ställe.** Raderna Foton, Säkerhetskopia och Säkerhet och lagring under Inställningar är nu en rad, "Säkerhet och lagring". Sidan har tre avsnitt: Lagring (hur mycket som används och om fotona sparas i mobilen), Säkerhetskopia (påminnelsen eller den automatiska kopian, Säkerhetskopiera och Läs in säkerhetskopia) och Säkerhet (PIN-kod eller lösenord). Länken i påminnelsen går direkt till avsnittet Säkerhetskopia.
- **"Mått och avstånd".** Valet i exportrutan som tar med de sparade mätningarna heter nu "Mått och avstånd".
- **Mät vinkelrätt och Mät fritt är egna verktyg.** I Mät trycker du direkt på hur du vill mäta – du behöver inte längre välja mätverktyget först och sedan sättet. Byter du sätt mitt i en mätning finns det du mätt kvar.
- **Snyggare rutor med val.** I alla verktyg står rutan med val i samma kolumn som verktygen och fortsätter i en kolumn till först när den första är full. Skalan i Mät tar aldrig mer plats än en knapp (en kalibrerad skala visas som "Kal.").
- **Klar är en grön bock som gör samma sak överallt.** Bocken avslutar det du håller på med och lägger ifrån sig verktyget, med ett enda tryck. Det gäller väggar, brandcellsgränser, mätningar och symboler. Inget raderas, och en färdig mätning står kvar med sin längd så att du kan spara den. Vill du bara avsluta en linje och direkt börja nästa dubbeltrycker du på ritningen.
- **Smalare valruta i symbolverktyget.** Rutan med Kopiera, Radera, Gör om och Ångra är nu en kolumn bred, som i de andra verktygen. Den står under symbolerna, eller bredvid dem när den inte får plats där.
- **Sparade mätningar går att redigera** i "Mät": tryck på en mätning för att välja den, så får varje punkt en styrpunkt. Dra i en styrpunkt för att flytta punkten, eller i linjen för att flytta hela mätningen. En mätning ritad i räta vinklar behåller dem: flyttar du ett hörn följer grannpunkterna med så att vinklarna står kvar, och en ändpunkt glider längs sin linje.
- **Väggar som ritas i följd är en vägg.** En polylinje hålls ihop när du avslutar den: den väljs, flyttas och raderas som en helhet, och vald visar den en styrpunkt i varje hörn. Drar du i ett hörn följer båda väggarna som möts där med, som styrpunkter i AutoCAD eller Bluebeam. Med "Rätvinkligt" lägger sig hörnet i linje med grannhörnen när du kommer nära. Gäller väggar ritade från V1.6.9.
- **Gör om:** bredvid varje "Ångra" i ritverktygen och symbolerna finns nu en "Gör om"-pil som tar tillbaka det du ångrat. Ångra och Gör om ligger alltid längst ner i rutan med val, och suddet ligger sist bland ritverktygen.
- **Objektlistan öppnas i samma marginal som verktygen** (inställningen heter nu "Föredragen marginal" under "Inställningar → Layout och visning"), och marginalens knappar göms medan listan är öppen.
- **Ritningsinställningar är en meny** som de andra inställningarna: "Namn", "Underlag", "Pappersformat och symbolstorlek" och "Markerade områden", med nuvarande värde under varje rad. Varje del öppnas som en egen sida med tillbaka överst.
- **Underlag** visar filnamnet på underlaget du laddade upp (för underlag tillagda från V1.6.8) och "Ritningsordning": ritningarna i en lista där du flyttar dem upp eller ner med pilarna, utan att rutan stängs.
- **"Grupper"** i Uppdragsinställningar samlar grupperna och förvald grupp på samma sida.
- **Checklista och Snabbtexter:** en knapp, "+ Ny checkpunkt" respektive "+ Ny snabbtext", öppnar fältet. Efter en tillagd checkpunkt står fältet kvar för nästa.
- Uppdragstypen väljs när uppdraget skapas och går inte längre att ändra under "Uppdragsinformation".
- "Redigera ritningen" är borttagen från sidan "Ritning" – ritverktygen finns i ritningsvyn.
- Rutan "Sparas på enheten" på startsidan är borttagen (skyddade uppdrag visar fortfarande att de är skyddade).
- "Denna" och "Alla" i objektlistan står på samma rad, och "Välj" bredvid "+ Nytt objekt" är lika hög som den.
- Många texter är omskrivna och kortare, bland annat på startsidan, i exporten, under Samarbeta och i Ritningsinställningar. Knappar och sidor som texterna hänvisar till står inom citattecken och heter som i appen (till exempel "Placera på ritning", "Läs in säkerhetskopia", "+ Ny ritning").
- I flyttläget och när du markerar ett område står Avbryt och Klar alltid bredvid varandra.
- **Samarbeta går åt ett håll: ägaren skickar hela uppdraget, medhjälparen skickar sina ändringar.** Utbytet av ändringsfiler åt båda hållen blev lätt rörigt, så nu är rollerna tydliga:
  - Ägarens fil är alltid hela uppdraget – ritningarna med sina underlag, inställningarna och alla objekt med de slutliga numren. Den ersätter det medhjälparen har, utom det medhjälparen lagt till eller ändrat men inte skickat än; det ligger kvar och går med i nästa fil.
  - Medhjälparens fil innehåller medhjälparens egna nya och ändrade objekt. Nya objekt numreras efter ägarens när ägaren läser in filen, i den ordning de gjordes.
  - **Ändrar medhjälparen ett av ägarens objekt blir det ett förslag.** Ägaren får besked när filen läses in ("2 nya objekt, 1 förslag att granska"), objektet får en streckad ring på ritningen och märket "Förslag" i listan, och granskningen öppnas direkt – den finns också under Samarbeta och som knappen Granska N förslag i ritningsvyn. Där står vad som skiljer (beskrivning, grupp, kategori, prioritet, kontrollpunkter, plats, foton) med Godkänn och Avvisa per förslag, eller för alla på en gång. Godkänn lägger in medhjälparens version med numret kvar; Avvisa behåller ägarens. Ett nytt förslag för samma objekt ersätter det gamla.
  - **Medhjälparen kan inte radera ägarens objekt eller ritningar.** Objektrutan har ingen Radera-knapp för ägarens objekt, Välj-radering hoppar över dem med besked, och + Ny ritning och Radera ritningen finns inte hos medhjälparen. Skulle en radering ändå nå ägaren (en gammal fil) behålls objektet och ägaren får veta det. Sina egna objekt raderar medhjälparen som vanligt, och raderingen följer med till ägaren.
  - Medhjälparens egna tecken på ritningen (anteckningar, mått, symboler) stannar på medhjälparens telefon. Ägarens följer med i ägarens fil.
  - Knappen **Skicka alla mina objekt igen** hos medhjälparen skickar allt eget på nytt, om en fil kommit bort på vägen.
- **Osynkade objekt syns på ritningen** hos medhjälparen: ett objekt som ägaren ännu inte fått – nytt, eller ändrat sedan den senaste filen – ritas fyrkantigt (mjuka hörn) i sin vanliga gruppfärg. När filen är skickad blir det runt. Ägaren har aldrig fyrkantiga objekt, eftersom ägarens fil alltid är hela uppdraget. Checkpunkter är fortfarande vita med streckad kant. Protokollen påverkas inte.
- Uppdragets kort på startsidan visar "N förslag" hos ägaren när förslag väntar.

**Fixat**
- **Rätt sak väljs i symbolverktyget.** Ett tryck på en symbol eller en anteckning som ligger på en brandcellsgräns väljer nu symbolen eller anteckningen, inte gränsen under.
- **Säkrare inläsning av filer.** Bilder i säkerhetskopior och samarbetsfiler som är orimligt stora hoppas över, så att en trasig eller tillverkad fil inte kan få appen att krascha. Meddelandet efter inläsningen säger hur många bilder som var skadade eller för stora.
- **Sparfel syns.** Om ett foto inte kunde sparas i objektet efter uppladdningen säger appen nu till (webbversionen).
- **Förstoringsglaset hamnar inte längre utanför skärmen.** När du ritade nära nederkanten eller verktygen kunde förstoringsglaset hamna nedanför skärmen eller under menyerna. Nu står det alltid helt på ritytan, helst ovanför fingret, och flyttar sig åt sidan förbi verktygen.
- **Rutan ovanför ritverktygen klipps inte längre.** På en låg skärm kunde väggbredden hamna under rubriken så att den inte gick att trycka på. Rutan fyller nu kolumnen ovanför verktygen och fortsätter bredvid först när den är full.
- **Meddelanden täcker inte längre verktygen.** På smala telefoner kunde ett meddelande i ritverktygen eller symbolerna lägga sig över Ångra. Nu står det i det fria utrymmet bredvid verktygen, även när meddelandet kom innan verktygen öppnades.
- **Sparade mätningar visar sin linje igen**, streckad mellan punkterna. Sedan V1.5.7 syntes bara punkterna. Samma fel tog bort pilspetsen på textrutornas pilar i ritningsvyn; den syns nu igen (exporten var inte påverkad).
- **Objekt i äldre uppdrag i webbversionen syns igen.** Uppdrag som sparades i webbversionen före V1.5.7 visades utan objekt, eftersom objekten låg kvar i det äldre sparformatet. Objekten var aldrig borta: de, fotona och de extra platserna läses nu in som vanligt (varje extra plats blir ett eget objekt, numrerat efter de andra, som i appens flytt från V1.5), och nästa sparning skriver dem i dagens format.

---

## V1.6 (2026-11-08)

Samlar ändringarna V1.5.1–V1.5.22.

**Innan du uppdaterar från V1.5:** uppdragen i appen följer med automatiskt vid första starten (se nedan), men gör gärna en säkerhetskopia eller exportera protokollen först – det kostar inget.

**Nytt**
- **Uppdragen följer med från V1.5.** Vid första starten efter uppdateringen flyttas allt som fanns i appen över till den nya lagringen: uppdrag, ritningar, foton, snabbtexter och inställningar. Har du PIN-kod ber appen om den gamla koden först, och koden gäller sedan som vanligt. Underobjekt (4.1, 4.2 …) blir egna objekt med samma text, numrerade efter de andra. Säkerhetskopior gjorda med V1.5 (med eller utan lösenord) kan också läsas in.
- **Samarbeta – två i samma uppdrag, utan server.** Under Uppdragsinställningar → Samarbeta bjuder du in en medhjälpare med en kod (QR-kod eller text). Du som bjuder in är ägare och bestämmer numreringen. Medhjälparen får hela uppdraget som en fil, och sedan skickar ni ändringar till varandra som filer åt båda hållen – med Quick Share, Bluetooth, mejl eller vad telefonen har i sin dela-meny. Objekt som inte skickats är märkta "Ej synkad", och planvyn har knappen Skicka N ändringar. Medhjälparens objekt numreras efter ägarens när de läses in, och vid en krock gäller ägarens version. Filerna är krypterade med koden.
- **Logga i protokollet.** Ladda upp en logga (JPG, PNG eller SVG) under Inställningar → Logga och välj vänster, mitten eller höger. Den läggs i sidhuvudet på tabellsidorna i PDF och Word när "Exportera med logga" är på.
- **Checklista.** Egna kontrollpunkter under Uppdragsinställningar → Checklista. De kan placeras på ritningen (streckad bricka med bock) och blir ett vanligt objekt när de får beskrivning eller foto. Före exporten visas checklistan, och appen frågar om du vill gå vidare med punkter kvar. Checklistan följer aldrig med i protokollet.
- **Översiktsritningarna i exporten är ritningens egen sida** i full storlek (A1 förblir A1), utan rubriker och sidfot. Uppdragets uppgifter och symbolförteckningen står i en ruta i ritningshuvudets stil, placerad där ritningen har plats.
- **Symbolstorlek per plan** (Planinställningar): Auto efter pappersformatet, eller ×1–×3, för symboler, anteckningar och exportens nummer.
- **Utgåva/status** som nytt fält i Uppdragsinformation. Tomma uppgifter följer aldrig med i protokollet.
- **Inställningar är en meny** i samma stil som Uppdragsinställningar: Utseende, Ritningen, Foton, Logga, Säkerhet och lagring, Android-app, Fellogg och Integritet, med nuvarande värde under varje rad.
- Startsidans knapp heter **Läs in fil** och tar emot både säkerhetskopior och delade uppdrag.
- Uppdragets kort på startsidan visar "Delat" när uppdraget delas.
- **Välj appens färg** under Inställningar → Utseende → Färgtema: Orange (som förut), Blå, Grön, Petrol, Lila eller Grafit. Knappar, flikar, länkar och kryssrutor byter färg, i både ljust och mörkt läge. Ritningen och protokollet påverkas inte.
- Nya symboler i planvyn: Uppdragsinställningar är en mapp med ett litet kugghjul och Planinställningar ett våningsplan med samma kugghjul i hörnet. Det ensamma kugghjulet betyder bara appens egna inställningar.

**Ändrat**
- **Underobjekt (4.1, 4.2 …) är borttagna.** Grupper och kategorier gör samma jobb. Kan komma tillbaka i en bättre form, till exempel som en indelning vid exporten.
- **Uppdragstypen Anteckningar är borttagen.** En inventering utan ritning gör samma sak och kan få en ritning senare. Valet heter "Med ritning" och "Utan ritning".
- Alla undersidor i appen har samma mönster: tillbakalänk överst ("‹ Inställningar", "‹ Uppdragsinställningar") och Stäng nederst. Knapparna Tillbaka och Klar är borta.
- Inga fält delar rad i formulären, på alla skärmbredder.
- Kortare och tydligare texter i Inställningar, i rutan Uppdragstyp och i rutan för nytt uppdrag ("Namn på ritning", "t.ex. Plan 1", "Ej angivet").
- Rubriken Uppdragsinställningar visar uppdragstypen under rubriken i stället för bredvid, så den bryts inte på smala skärmar.
- Knapparna Säkerhetskopiera och Radera uppdraget lägger sig på var sin rad på smala skärmar.
- Webbversionen visar det som bara finns i appen som dämpade rader märkta "Endast i appen".
- Stor genomgång av koden: gamla namn och onödig bakåtkompatibilitet borttagna. Säkerhetskopior från V1.2–V1.4 kan inte läsas in i V1.6 (de från V1.5 kan). Från och med V1.6 går kopior från de två senaste versionerna alltid att läsa in, och det kontrolleras automatiskt inför varje ny version.
- Inför uppladdningen: hela koden genomgången och uppstädad, och fyra nya testsviter som inte fanns förut – "apan" (slumpmässiga tryck, svep och inmatning i en minut, allt ska hänga ihop efteråt), avbrottstestet (appen dödas mitt i en sparning, en radering, en PIN-ändring eller en inläsning och startas igen – inget får gå sönder), startmätningen (storlek och starttid med budgetar) och en kontroll av att alla texter i appen är svenska.

**Fixat**
- Efter låsning låg uppdragsnamn, kontrollantens namn och grupp- och kategorinamn från en export kvar i minnet. Nu töms allt.
- Ett objekt som visats på flera platser i V1.5 får efter flytten rätt nummer på varje plats, även om den gamla lagringen innehöll dubbletter eller trasiga bildhänvisningar.
- Checklistans knappar Placera/Flytta och Ta bort lägger sig under texten på smala skärmar, så att ett långt ord ("brandcellsgränsen") inte bryts mitt i.
- Knappen Ta emot fil under Samarbeta såg ut som en rubrik i versaler; nu en vanlig knapp. Inbjudningskoden håller sig på en rad även med stor text.
- Mappsymbolen för Uppdragsinställningar fyller sin knapp lika mycket som plansymbolen (den var något liten).
- Säkerhetskopiera alla och Läs in fil på startsidan får var sin rad på telefoner (de delade rad och "Säkerhetskopiera alla" bröts på två rader).
- "Säkerhetskopiera" bröts mitt i ordet på smala skärmar.
- Rubriken "Uppdragsinställningar" bröts på två rader på smala skärmar (med stor text krymper rubriken lite i stället).

---

## V1.5 (2026-11-05)

Samlar V1.4.1–V1.4.18.

**Nytt**
- **Grupper.** Varje objekt tillhör en grupp (Brister och Noteringar från början, eller egna). Gruppen ger objektets färg på ritningen och blir ett eget avsnitt i protokollet. En förvald grupp för nya objekt väljs genom att hålla inne en grupp, eller under Uppdragsinställningar. Objekt kan också vara utan grupp.
- **Kategorier** är egna och valfria (till exempel Utrymningsväg) och färgar numren på exportens översiktsritningar.
- **Symbolförteckning** under varje översiktsritning: kategorierna, skyltarna som används, anteckningar och "Kompletterat på plats – saknas i ritningsunderlaget".
- **Fem nya ISO 7010-skyltar:** Återsamlingsplats, Utrymningsfönster med stege, Räddningsfönster, Utrymningsstege och Utrymningshiss, samt Utrymningsfönster. Tillgänglighetsanpassad vägledande markering, vit och efterlysande. Skyltarna sorterade efter färg.
- **Sparade mätningar** i Mät, med namn, exporterade på en egen översiktsritning med "Exportera med mätningar".
- **Täta objekt visas som prickar.** I en klunga behåller ungefär varannan markör sitt nummer och resten visas som små prickar i gruppens färg. Prickarna följer med när du zoomar och får tillbaka numret när det finns plats. Kan stängas av under Inställningar → Ritningen.
- **Runda knappar i marginalen** nertill, där tummen når dem: objektlistan, Uppdragsinställningar, Planinställningar, ISO, Mät och pennan. Till vänster eller höger efter vilken hand du håller telefonen i (Inställningar → Ritverktygen). Knapparna tonas ner medan ritningen flyttas.
- Pappersformatet "Annat" med egna mått.
- Säkerhetskopian är en vanlig zip-fil med uppgifterna som JSON och ritningar och foton som filer, så den kan öppnas utan appen. Snabbtexterna och kontrollantens namn följer med.
- Appen tål telefonens textstorlek upp till 150 % utan att något klipps.
- Fotons EXIF-data (position, telefonmodell) tas bort när de läses in. Bilder över 260 megapixel nekas.
- Med PIN-kod på hålls flera öppna flikar i samma webbläsare i takt: låses en, låses alla.
- Alla tryckytor är minst 44 px, och alla rutor har namn för skärmläsare.

**Ändrat**
- Exportvalet "Endast brister på översikt" ersatt av "Symboler visas på", med en ruta per grupp. Exportvalet heter "Redigerbara symboler".
- Sidhuvudet i protokollet säger "Platsbesök" och datum för alla uppdragstyper.
- "Mer" heter Uppdragsinställningar, och "Ändra ▾" på planfliken heter Planinställningar.
- Inget ritverktyg är förvalt, så det som redan är ritat kan plockas upp direkt.
- Exportens bilder packas vid sidan av huvudtråden, och numreringen på översikten placeras 6–8 gånger snabbare.

**Fixat**
- Svart ruta vid symbolkolumnen och svart vald anteckning i mörkt läge.
- Kamerans tillfälliga fil på Android raderas efter fotot.
- Appen säger tydligt ifrån när lagringen är full.
- Webbversionen uppdaterar sig även när webbläsaren har en egen kopia av filerna.
- Text på en kategoris färg är svart eller vit, det som läses bäst.

---

## V1.4 (2026-11-03)

Samlar V1.3.2–V1.3.14.

**Nytt**
- **Symbolverktyget (ISO).** ISO 7010-skyltar på ritningen: handbrandsläckare, inomhusbrandpost, brandlarmsknapp, utrymningsplats och vägledande markeringar uppåt, neråt, åt vänster och åt höger. Symbolerna är 7,5 mm på ritningens papper; pappersformatet läses från PDF:en eller väljs när ritningen läggs in.
- **Anteckning med hänvisningspil:** en gul ruta med text och en blå pil till platsen den gäller.
- **Redigerbart i Bluebeam och Acrobat:** symbolerna och anteckningarna ligger som markeringar i PDF:en och kan flyttas, ändras och få ny text.
- Med symboler blir det två översiktsritningar i PDF:en: en med bara symbolerna och en med bristerna ovanpå (eller bara bristerna, med valet "Endast brister på översikt").
- Excel har ett blad med antal av varje symbol.
- **Förhandsvisning:** översiktsritningarna visas medan du väljer vad som ska med, och den färdiga filen kan bläddras igenom sida för sida innan du sparar.
- **Ritverktygen som symboler i en kolumn** i vänsterkanten. Tryck på ett verktyg igen för att lägga ifrån dig det. Håll inne något du ritat för att lyfta och flytta det, dra i en ände för att ändra längden.
- **Mät** har en egen knapp ovanför pennan och visar med en decimal, i km från 1 000 m.
- Stora exporter delas i flera PDF- och Word-filer (2 000 objekt per fil).
- En mätare under Inställningar visar hur mycket lagring varje uppdrag tar.
- Lägesbilderna i protokollet visas utan symboler.

**Ändrat**
- Inställningarna med varje förklaring direkt under sin inställning, och PIN-koden flyttad från startsidan till Inställningar.
- Startsidan: "+ Nytt uppdrag" centrerat på breda skärmar, "Obj." som kortform, grön bock i stället för hänglås på statuskortet.
- Medan ett verktyg är ute visas bara dess egen knapp.
- I webbversionen i Claude visas det som bara den installerade appen kan som dämpade platshållare ("Endast i appen").

---

## V1.3.1 (2026-11-01)

**Fixat**
- Att ta eller välja ett foto och spara objektet går snabbt även med mycket stora kamerabilder: kameran lämnar över högst 2 560 px, och nya foton förminskas i bakgrunden så fort de lagts till.

**Ändrat**
- Appen säger "objekt" överallt där det stod "punkt": objektlistan, underobjekt, "Välj flera objekt".

---

## V1.3 (2026-11-01)

Samlar V1.2.4–V1.2.20.

**Nytt**
- **Lösenord som alternativ till PIN-kod**, med styrkemätare. Kontrollantens namn sparas krypterat.
- **Mer** är en meny med sidor: Uppdragsinformation, Kategorier, Snabbtexter samt Säkerhetskopia och radering.
- Före exporten visas det som saknas (objekt utan foto eller beskrivning) överst i Exportera, med en väg rakt dit.
- Håll inne ett uppdrag på startsidan för Redigera eller Radera. Svep in från kanten för att öppna objektlistan.
- Sortering av uppdragen på "Senaste". "Visa tips" kan stängas av.
- Ritverktygens Ångra står bredvid "Avsluta linjen" och backar ett steg i taget, även efter att verktygen stängts och öppnats igen.
- Skala och kalibrering mot en känd längd bland ritverktygen, så måtten visas i meter. Inställningen "Spara foton i mobilen".
- "Ladda ner V… för Android" under Inställningar i webbversionen: en vanlig länk till APK-filen i samma version på GitHub. Appen hämtar eller skickar fortfarande ingenting själv.

**Ändrat**
- Samma ord överallt: uppdrag, plan, datum, uppdragsinformation, lägesbilder, radera.
- En enda "Är du säker?"-ruta för allt som raderar, med lika breda knappar.
- Inga zoomknappar – nyp för att zooma. Tydligare planflikar. Svep mellan plan borttaget.
- Ett typsnitt och en liten skala av textstorlekar överallt. Mjuka övergångar mellan startsidan och ritningen, som kan stängas av ("App-animeringar").
- Meddelanden visas i nedre delen av skärmen. Snyggare menyer med lika breda knappar.

**Fixat**
- Objektlistan hoppade tillbaka när man rullade i den, och den sista raden låg gömd under Exportera-knappen.
- Texten "null" kunde dyka upp över ritningen när dagens tips visats.
- Tillståndet hålls ihop vid parallellt arbete, och fel loggas och visas i stället för att sväljas tyst (Fellogg).

---

## V1.2.3 (2026-10-31)

**Nytt**
- GitHub bygger även en AAB-fil för Google Play, vid sidan av APK-filen.

## V1.2.1 (2026-10-31)

**Fixat**
- Arbetsflödet som bygger Android-appen hos GitHub.

## V1.2 (2026-10-31)

**Nytt**
- **Android-appen.** Byggs automatiskt av GitHub varje gång koden laddas upp. Egen lagring på telefonen och ingen behörighet att använda internet. Exporter och säkerhetskopior sparas i Dokument/PlanPin, kamerafoton kopieras till Bilder/PlanPin, "Maila / dela" öppnar Androids delningsmeny.
- Webbappen fungerar som förut och uppdaterar sig själv.

---

## V1.1 och tidigare

Webbappen på GitHub Pages: tre uppdragstyper (Inventering med prioritering, Utförandekontroll med kontrollpunkter enligt BFS 2024:7, Anteckningar utan ritning), ritning som PDF eller bild, numrerade punkter med underpunkter, foto med markering i bilden, beskrivning med snabbtexter, kategorier med färger, flera plan, ritverktyg (väggar, dörrar, fönster, sudd, mätning), punktlista med sök och filter, export till PDF, Word och Excel med lägesbilder, PIN-kod med AES-256-kryptering, krypterade säkerhetskopior, ljust och mörkt läge, fungerar utan uppkoppling.
