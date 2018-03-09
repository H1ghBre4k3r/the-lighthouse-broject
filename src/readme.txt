Um Breakout so elegant und effizient wie möglich zu pogrammieren, haben wir uns dazu entschieden, das Spiel in mehrere verschieden Klassen und Paktete zu unterteilen.
Das Spiel wird grundsätzlich über die main-Methode in der gleichnamigen Klasse gestartet. Von dort aus wird das "Problem" (in diesem Fall das Spiel) in kleinere
Klassen unterteilt, die alle für einen gewissen Bereich oder eine gewisse Aufgabe im Spiel zuständig sind. Hierbei sind wir nach dem MVC-Pattern vorgegangen.

Zu aller Erst wäre da das Model, welches alle wichtigen Informationen über den aktuellen Status des Spiels enthält. "Organisiert" wird das Model bei uns von der 
ModelController-Klasse. Sie erschafft alle Objekte im Spiel - also den Ball, den Spieler und das "Spielfeld" (die Bricks, die es zu zerstören gilt) - und 
enthält Variablen über den aktuellen Status des Spiels - also ob das Spiel überhaupt schon gestartet wurde, wie viele Leben der Spieler noch hat, ob er bereits 
gewonnen oder verloren hat etc. Der Spieler wird hierbei natürlich von dem Benutzer über Eingaben (Maus oder Tastatur) gesteuert, hierzu kommen wir aber später. 
Das Spielfeld stellt einen 2-dimensionalen Array aus Bricks, welche Informationen über ihre Position, ihre Farbe und ihren "Status" (ob sie aktiv/vorhanden oder 
"inaktiv"/gelöscht sind) enthalten, dar. Es enthält ebenfalls Informationen über das Aussehen der Bricks. Dieses ist abhängig davon, wie viele Bricks horizontal 
vorhanden sind und davon, wie hoch das Fenster ist (Breite der Bricks = Breite des Fenster / Anzahl der horizontalen & Höhe der Bricks = Höhe des Fensters / 14).
Das aufwendigste Objekt hierbei ist der Ball; er fliegt über das Spielfeld und prallt an Wänden, an dem Spieler (hierbei 
ist der Winkel, in dem er abprallt abhängig davon, wo er den Spieler getroffen hat) und an den Bricks am. Trifft er einen Brick, wird dieser "gelöscht" - hierbei 
wird lediglich die "Status"-Variable in der Brick-Klasse geändert. Nach dem "Löschen" eines Bricks wird die Geschwindigkeit des Balls erhöht, was die Schwierigkeit 
des Spiels steigern soll. Sind alle Bricks gelöscht, hat der Spieler das Spiel gewonnen und darf es noch einmal spielen, wenn er möchte. Sollte er jedoch alle 
Leben verlieren, was durch das Berühren der unteren "Wand" passiert, hat er das Spiel verloren; selbstverständlich darf er es dann trotzdem nochmal versuchen. 
Für diesen "Reset" besitzt die ModelController-Klasse eine Methode, in der die wichtigen Objekte (Ball und Spielfeld) neu initialisiert und die Status-Variablen 
zurückgesetzt werden. 
Die Bewegung des Balls wird durch die Klasse "BallMovementTimer" organisiert. Sie ist ein Timer, welcher - in Abhängigkeit von seiner Geschwindigkeit - den 
Ball bewegt und dabei immer überprüft, ob aktuell alle Bricks zerstört sind. Diese "Abfrage" in diese Methode zu implementieren ist daher sinnvoll, dass dafür kein 
extra Thread gestartet werden muss und es dadurch zu keinen Komplikationen kommen kann. Die für das Abprallen notwendige Kollisions-Abfrage wird ebenfalls von einer 
Klasse (CollissionDetection) übernommen. Ihre Methoden sind alle statisch, damit sie immer und zu jedem Zeitpunkt aufgerufen werden können, ohne dass vorher ein 
Objekt erzeugt werden muss. Sie bekommt alle für die Kollision wichtigen Objekte bei ihrem Aufruf als Parameter übergeben und wertet diese dann aus (überprüft, 
ob der Ball auserhalb des Spielfelds ist oder in/an einem Brick oder dem Spieler).
Grundsätzlich sind ALLE Variablen 'private', damit von außen nicht ungewollt auf sie zugegriffen werden kann. Sollte dennoch ein Zugriff notwendig sein, zum Beispiel 
um den Wert einer Variablen (sei es die aktuelle Position des Balls oder die aktuelle Instanz des ModelControllers) zu erhalten, haben wir für diese Variablen
public Getter-Methoden geschrieben. In einigen wenigen Fällen ist es notwenig, dass der Wert einer Variable von außerhalb der Klasse geändert wird; hierfür haben 
wir public Setter-Methoden implementiert, die teilweise die Parameter überprüfen, bevor die Variable in der Klasse geändert wird (z.B. beim setzen der neuen 
Koordinaten des Spielers). Wir haben es soweit wie möglich versucht, alle wichtigen Varaiblen und Objekte direkt beim Konstruktor-Aufruf zu übergeben, damit nicht 
extra Methoden-Aufrufe notwendig sind - teilweise lies es sich jedoch nicht verhindern.

Nun kommen wir zu unser Implementierung des Views: 
Unser View wird von unserem ViewController orgranisiert. Er erschafft und organisiert alle Views, die wir implementiert haben - den DesktopFrame und den 
LighthouseView. Der DesktopFrame ist ein JFrame, der die klassichen Eigenschaften eines Fensters besitzt - Titel, Höhe, Breite etc. Er erschafft jedoch die 
Zeichenfläche und den InputController - unsere Implementierung des Controllers, zu dem wir später noch kommen werden. Die Zeichenfläche ist ein JPanel, welches 
den gesamten DesktopFrame ausfüllt und bei jedem "Zeichen-Durchgang" die aktuellen Koordinaten der Objekte aus dem ModelController abfragt und die Objekte and ihre 
Positionen zeichnet. Des Weiteren werden noch Informations-Texte abhängig vom aktuellen Status des Spiels "geschrieben" - Anzahl der Leben, ob gewonnen/verloren etc. 
Der LighthouseView ist für die Darstellung von Breakout auf dem Hochhaus zuständig. Hierfür Initialisiert er eine neue Instanz des LighthouseDisplays und sendet bei 
jedem "Zeichen-Durchgang" einen Byte-Array an das Display. Dieser Byte-Array wird anhand der Daten vom Model so erstellt, dass das Spiel auf dem Hochhaus fast genau so 
aussieht wie auf dem DesktopFrame - hierbei sind die Daten über die Bricks (also deren Höhe und deren Breite) sehr hilfreich, da diese leicht auf das Lighthouse 
"umzurechnen" sind. Für die Position des Balls und des Spielers wird ausgerechnet, in welchem Fenster sich der Ball und der Spielder rein rechnerisch befinden 
(also welche Fenster ihren Koordinaten ungefähr entsprechen). Es gibt dazu noch extra Anzeigen für das Leben (in der obersten Reihe die Fenster ganz rechts stellen 
die Leben dar) und wenn der Spieler gewinnt (grünes Aufblinken des Lighthouses) und wenn der Spieler Leben verliert (rotes Aufblinken des Lighthouses). Dieser 
Byte-Array wird dann bei jedem Durchgang an das Lighthouse gesendet.

Zu guter Letzt kommen wir zu unser Implementierung des Controllers:
Bei uns kann der Nutzer den Spieler entweder über die Pfeiltasten (KeyListener) oder über die Maus (MouseMotionListener) steuern. Hierfür haben wir eine Klasse 
InputController implementiert, die die Eingaben des Nutzers organisiert. Sollte der Spieler einer der Pfeiltaste Link oder Rechts klicken, so bewegt sich die 
Spielfigur in die entsprechende Richtung. Hierbei kann es jedoch zu teils starken Verzögerungen kommen, da die "KeyPressed"-Methode durch die Tastatur nicht 
kontinuierlich, sondern mit kleinen Abständen aufgerufen wird. Um diese Verzögerung zu verhindern haben wir die Funktion hinzugefügt, den Spieler mit der 
Bewegung seiner Maus zu steuern. Hierbei wird immer dann, wenn die Maus vom Nutzer bewegt wird, der Mittelpunkt des Spielers auf die x-Position der Maus gelegt - 
dadurch sind nahezu uneingeschränkt flüssige Bewegungen möglich.