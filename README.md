# ESharing 

Erstellen und Implementieren Sie für folgenden Sachverhalt die entsprechenden Klassen,
Interfaces und Enums. Nutzen Sie ggf. auch eine Vererbungshierarchie und definieren Sie alle
nötigen Klassen- und Instanzvariablen, sowie Klassen- und Instanzmethoden, die im
gegebenen Szenario gefordert oder benötigt werden. Nutzen Sie auch Packages um
Funktionalitäten zu kapseln.
Nutzer können über eine Sharing-Plattform für Elektromobilität Tretroller, Fahrräder,
Motorroller und Autos bei verschiedenen Anbietern (A Bikes, B Mobile, und C Share)
sekundenweise ausleihen.
Nutzer der Plattform haben einen Nutzernamen, bekommen eine Nutzer ID zugeordnet,
wählen initial und einmalig einen Tarif (welcher später im Verlauf des Programms auch nicht
geändert werden kann), haben einen Führerschein für verschiedene Fahrzeugklassen (Auto
und oder Roller, verwenden Sie hier ein Enum) und haben ein Guthaben/
Zahlungsaufforderung gegenüber der Plattform. Sie können nicht mehrere Fahrzeuge
gleichzeitig ausleihen/reservieren.
Prepaid-Kunden können ihr Konto mit Guthaben aufladen und dieses dann anschließend
einlösen und Fahrzeuge mieten. Sobald das eingezahlte Guthaben aufgebraucht ist, ist keine
weitere Miete eines Fahrzeugs möglich. Im Standardtarif können Kunden auch Guthaben
aufladen, jedoch können auch ohne Guthaben weitere Fahrzeug ausgeliehen werden.
Verwenden Sie auch für den Tarif ein Enum (Prepaid, Standard).

Jedes Fahrzeug kann über die Plattform reserviert und ausgeliehen werden. Fahrzeuge haben
eine ID, eine Bezeichnung (z.B. das Kennzeichen), einen Akku mit prozentualer Kapazität und
sind einem Anbieter zugeordnet. Die Schnittstellen zu den Fahrzeugen und den Anbietern
sind in den Dateien IShareable.java und IProvider.java (siehe ISIS-Kursseite) gegeben (Sie
können diese jedoch, je nach Lösungsansatz erweitern/verändern). Ein Fahrzeug soll nur
reserviert/ausgeliehen werden können, wenn der Nutzer die entsprechende Fahrerlaubnis
besitzt und er, je nach Tarif, über ausreichend Guthaben verfügt. Außerdem muss der Akku
eine gewisse Restkapazität (in %) aufweisen. Diese ist für jeden Anbieter individuell (A – 20%,
B – 25%, C – 30%). Falls ein Fahrzeug reserviert wurde, kann es nur von dem entsprechenden
Nutzer gemietet werden. Ein Fahrzeug kann letztlich nicht von mehreren Nutzern gleichzeitig
ausgeliehen sein.
Alle Tretroller haben eine farbige LED, welche in den Farben Rot (kann nicht gemietet
werden), Grün (kann gemietet werden), Gelb (reserviert), oder Blau (aktive Miete) leuchten
kann (Nutzen Sie auch hier ein Enum).
Fahrräder besitzen ein Schloss, welches offen (aktive Miete) oder geschlossen/gesperrt
(sonst) sein kann.
Roller müssen bei aktiver Miete stets Vorder- und Rücklicht angeschaltet haben. Außerdem
soll ein Standlicht (ebenfalls vorne und hinten) eingeschaltet werden, wenn ein Roller von
einem Nutzer reserviert wurde.
Autos sollen ebenfalls durch ihr Standlicht eine Reservierung kenntlich machen
(Scheinwerfer und Rücklicht sind nicht zu berücksichtigen). Auch Autos können, ähnlich wie
Fahrräder, abgeschlossen werden.
Der reguläre Preis für führerscheinfreie Fahrzeuge, also Tretroller und Fahrräder, ist für jeden
Anbieter individuell (A – 8ct/s, B – 9ct/s, C – 9ct/s). Roller kosten bei den Anbietern A und B
11ct/s, bei Anbieter C 9ct/s. Autos kosten bei allen Anbietern 15ct/s.
Der Akku von Tretrollern entlädt sich um durchschnittlich 2% pro Sekunde, von Fahrrädern
um 1%/s, von Rollern um 4%/s, und von Autos um 6%/s. Der (aktuelle) Wert der
Akkukapazität wird beim Beenden der Miete aktualisiert und kann nie unter 0% sinken.

# Manager
Erstellen Sie letztlich eine Manager-Klasse zur Verwaltung der 3 Anbieter, verschiedenen
Fahrzeugen (verteilt auf alle Typen) und einigen Nutzern (verteilt auf alle Tarife und
Führerscheinklassen). Reservieren und mieten Sie einige Fahrzeuge durch Nutzer und
beenden Sie die Ausleihen wieder (siehe output.txt zur Orientierung, ein interaktiver
Manager ist nicht gefordert). Tipp: über Methoden wie IOTools.readLine() können Sie auf
eine Nutzereingabe warten und eine gewisse Zeit vergehen lassen.
