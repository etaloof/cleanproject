# cleanproject
Clean Spring Boot Projekt für DHBW

Bauen über integriertes Maven: mvnw clean install
Start über de.dhbw.CleanProjectApplication::main

Danach ik Browser http://localhost:8080/api/stellenangebot aufrufen


# Portal für die Jobsuche

Ziel des Programmentwurfs ist die Erstellung eines Online Portals für die Jobsuche. Das
Portal soll Arbeitssuchenden die Suche nach einem passenden Arbeitsplatz erleichtern. Die
Implementierung erfolgt mit dem Java Framework _Spring Boot_ unter Anwendung der _Clean Architecture_.
Das Portal soll eine Liste mit aktuellen Stellenangeboten anzeigen. Über eine Suchfunktion
lassen sich die für den Benutzer interessanten Einträge einschränken. Die angezeigte
Stellenangebote sollen nach relevanten Eigenschaften gefiltert werden und nach
Sortierungskriterien sortiert werden.
Zu jedem Angebot soll es eine Seite mit Details geben, auf der ein Beschreibungstext und
die üblichen Eigenschaften angezeigt werden.
Es soll möglich sein, dem System neue Jobs hinzuzufügen und zu speichern.

### Funktionalität

#### Stellenangebot
- Titel
- Beschreibungstext
- Link zur Seite des Unternehmens
- und alle Filtereigenschaften

#### Filtereigenschaften
- Standort
- Arbeitszeit
- Veröffentlichungsdatum
- Ablaufdatum
- Berufserfahrung
- Unternehmen
- Branche

#### Sortierungskriterien
- Alphabetisch
- Veröffentlichungsdatum

### Use Cases

Damit werden die folgenden Use Cases abgedeckt:

1. Auflistung aller aktuellen Stellenangebote
2. Suchfunktion zur Einschränkung der Ergebnisse basierend auf dem Beschreibungstext
3. Filtern der Stellenangebote nach besonderen Eigenschaften
4. Sortieren der Stellenangebote

Um den Anforderungen an eine solche Applikation gerecht zu werden, wird die Implementation aus mehreren Perspektiven betrachtet. Dazu werden die genannten Themen beschrieben und ihr Einfluss auf die Durchführung des Projekts erläutert.

* Clean Architecture
* Domain Driven Design
* Programming Principles
* Unit Tests
* Refactoring
* Entwurfsmuster

## Clean Architecture
Die generelle Architektur der Applikation wird mit der mehrschichtigen, sogenannten "Clean Architecture" umgesetzt. Das Ziel dieser Architektur ist es, Abhängigkeiten von Frameworks und Bibliotheken über den Lebenszyklus der Applikation zu vermeiden.

Clean Architecture versucht durch die Trennung der Applikation in Schichten, die Auswirkung von Änderungen in den äußeren Schichten abzufangen. Damit müssen nur an den äußeren Schichten Anpassungen durchgeführt werden.

Dabei gilt der Grundsatz: Abhängigkeiten verlaufen von außen nach innen (vgl. Dependency Inversion Principle). Effektiv wird die Applikation in mehrere Ebenen aufgeteilt, die sich in ihrer Abstraktheit unterscheiden. Low-Level Code, also Code mit geringem Abstraktionsgrad, wird in den äußeren Schichten angesammelt; der abstrakte High-Level Code wird in den inneren Schichten angesammelt.

Die Clean Architecture scheint ein geeigneter Ansatz zu sein, um die Applikation umzusetzen. Aufgrund der Trennung in Schichten kann sichergestellt werden, dass die Applikation auch bei großen Änderungen in den Abhängigkeiten nur in den äußeren Schichten und nur minimal geändert werden muss. Da unklar ist, wie lange dieses Projekt entwickelt und gewartet werden wird sowie welche Anforderungen sich noch ergeben werden, ist eine hohe Flexibität des Code für die Umsetzung des Projekts von großer Bedeutung.

Daher werden vier Schichten für die Architektur gewählt (von außen nach innen in aufsteigender Reihenfolge):

0. Plugins - Darstellung/User Interface, Datenspeicherung
1. Adapters - Resource Mapping
2. Application Code - Use Cases
3. Domain Code - Entities

In äußersten Schicht, der Plugins Schicht, befinden sich Schnittstellen zu externen Systemen. Das umfasst die Darstellung für den Benutzer, sowie die permanente Speicherung der Stellenangebote.

Die Adapter Schicht entkoppelt die Schichten Plugin und Application Code voneinander.

Der Application Code implementiert die Use Cases.

Im Domain Code befinden sich die dafür benötigten DDD Entities und Aggregate.

## Domain Driven Design

### Value Objects

#### Gültigkeitszeitraum
- Start der Gültigkeit
- Ende der Gültigkeit

Der Gültigkeitszeitraum wird als Value Object modelliert, da er keine eigene Identität hat. Zwei Objekte von diesem Typ sind (bei gleichen Werten) nicht voneinander zu unterscheiden und sind gegen einander austauschbar.

#### Sortierungskriterien
- Alphabetisch
- Veröffentlichungsdatum

Die Sortierungskriterien sind ein Value Object, da sie nur zu für die Repräsentation eines Wertes benutzt werden und als Wert unveränderlich sind.

### Entities und Aggregate
Die folgenden Entities bzw. Aggregate wurden definiert:

#### Stellenangebot
- ID
- Titel
- Ersteller (Nutzer)
- Beschreibungstext
- Link zur Seite des Unternehmens
- Standort
- Arbeitszeit
- Veröffentlichungsdatum
- Ablaufdatum
- Berufserfahrung
- Unternehmen
- Branche

Ein Stellenangebot kann kein Value Object sein, da es nicht durch seine Eigenschaften eindeutig festgelegt wird.

#### Nutzer
- ID
- Vorname
- Nachname
- Status (arbeitssuchenden oder nicht)

Jeder Nutzer hat eine eigene Identität und wird durch seine ID identifiziert.

### Repositories

Das StellenangebotRepository wird als Abstraktion verwendet, um die Implementationsdetails der Persistierung zu verstecken. Auf diese Weise ist es einfach möglich, die Datenbank

### Domain Services

Die Filterfunktion aus dem Use Case (3) wird mit dem FilterStellenangeboteDomainService implementiert. Dadurch wird die komplexe Funktionalität aus dem Domainmodell ausgelagert. Der Grund dafür ist, dass sich diese Funktionalität nur schwer innerhalb des Domainmodell abbilden lässt.


### Ubiquitous Language

Für die Ubiquitous Language werden die folgenden Begriffe definiert:

#### Stellenangebot
Angebot, welches für die (arbeitssuchenden) Benutzer des Portals ausgeschrieben wurde.

#### Nutzer
Benutzer der Webseite. Kann neue Stellenangebote veröffentlichen.

## Programming Principles

Die Programming Principles basieren auf der Erfahrung vieler Entwickler und sollten grundsätzlich befolgt werden.

### SOLID

#### S

Das S in SOLID steht für das Single Responsibility Principle. Eine Klasse sollte nur eine Aufgabe haben, was die Komplexität reduziert. Komplexes Verhalten entsteht dann durch die Kombination von Objekten.
Beispiel: Der ContainsBeschreibungsTextStellenangebotFilter hat nur eine Aufgabe: Eine Implementierung des FilterStellenangeboteDomainService zu sein, eine Liste anhand des Beschreibungstexts der enthaltenen Stellenangebote zu "filtern". Das heißt, die Liste mit Stellenangeboten so zu transformieren, dass nur noch die Stellenangebote enthält, bei denen der Beschreibungstext mit dem Suchbegriff übereinstimmt.

#### L
Das O in SOLID ist das Open Closed Principle. Klassen sollen so angelegt werden, dass sie offen für Erweiterungen und geschlossen für Änderungen sind. Damit soll vermieden werden, dass die Umsetzung von neuen Anforderungen weitreichende Änderungen am bestehenden Code erforderlich macht. Daher setzt man auf Erweiterung durch die Vererbung beziehungsweise die Implementierung von Interfaces. Dann ist es ausreichend eine neue Unterklasse mit angepasstem Verhalten ergänzen, um die neue Funktionalität zu implementieren. Der bestehende Code muss nicht geändert werden.
Beispiel: Der FilterStellenangeboteDomainService und die zugehörigen Implementierungen der Filter Klassen wurden nach dem Open Closed Principle entworfen, damit sie möglichst modular verwendet werden können.

#### L
Das Liskov Substitution Principle beschränkt die Schnittstellen innerhalb des Codes. Das Liskov Substitution Principle fordert, dass Objekte eines abgeleiteten Typs als Ersatz für die Basisklasse funktionieren müssen, sodass das Programm korrekt bleibt.

Beispiel: Das Liskov Substitution Principle wurde bei den Implementierungen der Interfaces (z. B. FilterStellenangeboteDomainService, IsGültigStellenangebotFilter) berücksichtigt, da im Projekt keine Basisklassen eingesetzt wurden. Der Grund für die Umsetzung des Prinzips ist, dass die "Ersetzung durch andere abgeleitete Typen der gleichen Basisklasse/des gleichen Interfaces" für eine gute Modularität der Filter sorgt und bei der Erweiterung um neue Filter eine Komposition der Filter ohne Einfluss auf die Korrektheit möglich ist.

#### I
Das I steht für das Interface Segregation Principle. Dieses beschreibt, dass Anwender nicht von Funktionen abhängig sein sollten, die sie überhaupt nicht nutzen. Das kann erreicht werden, indem Interfaces und Klassen möglichst so angelegt werden, dass sie nur einen engen Anwendungsbereich haben.
Beispiel: Das Prinzip wurde im FilterStellenangeboteDomainService berücksichtigt, da dieses nur eine Methode erfordert. Damit können alle Stellen im Code, die den FilterStellenangeboteDomainService verwenden, nur von dieser einen Methode abhängig sein.

#### D
Bei dem Dependency Inversion Principle sollen Low-Level Module von High-Level Modulen abhängig sein, es sollten aber nicht High-Level Module von Low Level Modulen abhängig sein. Das bedeutet, das sich die Low-Level Details ändern können, ohne weitreichende Änderung im gesamten Code nach sich zuziehen.

Beispiel: Dies wurde schon im Vorfeld durch die Verwendung der Clean Architecture bedingt. Die High-Level Module aus dem Application Code (StellenangebotApplicationService) werden von Low-Level Modulen aus dem Plugin Code (StellenangebotController) verwendet. Eine Verwendung von Komponenten in der entgegengesetzten Richtung findet nicht statt.



### GRASP
Mit GRASP werden mehrere Grundprinzipien bezeichnet, mit dem Ziel "Die Lücke zwischen gedachten Domänenmodell und Softwareimplementierung (Designmodell) sollte klein sein".

#### Low Coupling
Low coupling wird im FilterStellenangeboteDomainService erreicht, indem die spezifischen Filter durch dieses Interface verwendet werden.

#### High Cohesion
Stellenangebot bündelt alle wichtigen Eigenschaften eines Stellenangebotes in sich. Damit sind die zusammenhängenden Eigenschaften im Code nahe beieinander.

#### Information Expert
Der StellenangebotApplicationService wird als Information Expert eingesetzt, um alle Stellenangebote zu bündeln. Um die Use Cases zu erfüllen, delegiert der Information Expert wenn notwendig an Filter und Sorter DomainServices.

#### Creator

#### Indirection
Mit dem StellenangebotController werden die Repräsentationen der Entitäten aus dem Domain Code und den Ressourcen aus der Adapter Schicht voneinander getrennt. Das wird erreicht, indem die StellenangebotApplicationService aufgerufen wird und mit dem StellenangebotToStellenangebotResourceMapper von Entitäten zu Resourcen gemappt wird. Der StellenangebotController gekoppelt daher auch den StellenangebotApplicationService und den StellenangebotToStellenangebotResourceMapper voneinander.

#### Polymorphism
Der StellenangebotApplicationService nutzt Polymorphismus, um zur Laufzeit festgelegte Filter und Sorter für die Erfüllung der Use Cases zu verwenden.

#### Controller
Der StellenangebotController erfüllt die Funktion eines Controllers, indem er den StellenangebotApplicationService und den StellenangebotToStellenangebotResourceMapper aufruft und an diese zur Erfüllung der notwendigen Funktionalität delegiert.

#### Pure Fabrication
Der AlphabeticSorter ist eine Pure Fabrication, weil er keinen direkten Bezug zum Domänenmodell hat. Er ist lediglich für die Sortierung einer (beliebigen) Liste zuständig und wird für die Implementierung von den domänenspezifischen Sortern benötigt.

#### Protected Variations



### DRY
DRY bedeutet "don't repeat yourself". Wird Code mehrfach wiederholt, dann wird dies dann zum Problem, wenn der Code geändert werden muss. Jede Kopie des wiederholten Codes muss geändert werden, was mühsam und fehleranfällig ist.

Bei den Unit Tests müssen die Mocks mit Testdaten initialisiert werden. Dazu wurde eine Duplizierung des Code so weit es möglich ist durch die Verwendung von Hilfsfunktionen vorgebeugt. Änderungen an den Objekten aus der Domain (falls nötig) sollten also nur einen geringen Aufwand erfordern, um die Tests anzupassen.

## Unit Tests
Um die korrekte Funktionsfähigkeit des Codes auch nach Änderungen oder Refactorings sicherzustellen, wird der Code mithilfe von Unit Tests getestet.

Die Tests wurden mit JUnit5 entwickelt und können mit `mvn test`/`mvnw test` ausgeführt werden.

## Refactoring

Bei einem Refactoring wird bestehender Code so geändert, dass die Qualität des Codes verbessert wird, während das Verhalten gleich bleibt.

Häufig ist die Erkennung von Code Smells die Grundlage für das Refactoring. Die folgenden Code Smells wurden im Projekt identifiziert:

- large class - Stellenangebot
- code duplication - Test code im StellenangebotApplicationServiceTest

### Refactoring 1 - large class
Die Entität Stellenangebot ist eine der umfangreicheren Entitäten, da sie diverse Eigenschafen von Stellenangeboten repräsentiert. Da zwei der Instanzvariablen ("gültigAb" und "gültigBis") aus der Sicht der Domain ein zusammenhängendes Paar bilden, können diese als Value Object ausgelagert werden. Die beiden Instanzvariablen durch das Value Object "Gültigkeitszeitraum" ersetzt. Somit wird die Verantwortung ("Einhalten der Invarianten eines Gültigkeitszeitraums") an das Value Object delegiert und muss nicht mehr von der Entität berücksichtigt werden.

Das Refactoring wurde im Commit fb10deb607962a6879e66dd3bbedfe0b7a845ca2 durchgeführt.

### Refactoring 2 - code duplication
Nach der Implementierung der Funktionalität zum Sortieren der Stellenangebote wurde in zwei Tests ein Mock Objekt sowie Hilfsfunktionen zur Generierung von Testdaten benötigt. Diese wurden in eine Basisklasse ausgelagert.

Das Refactoring wurde im Commit b90dc29f507c61e50e27bd1d6fa1cfd57efe5b63 durchgeführt.


## Entwurfsmuster
