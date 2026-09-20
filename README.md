# Assignment 2: Factory Method and Abstract Factory

This Java 17 console application combines transport delivery with a matching UI family. Factory Method chooses a truck or ship. Abstract Factory supplies both a button and a checkbox for Windows or macOS.

## Requirements

- JDK 17 or newer. The commands below compile against the Java 17 API.
- A terminal in this repository's root directory. No external libraries are needed.

## Packages

- `factorymethod`: `Transport`, `Truck`, `Ship`, `Logistics`, `RoadLogistics`, `SeaLogistics`.
- `abstractfactory`: `Button`, `Checkbox`, four platform components, `GUIFactory`, and two platform factories.
- `app`: `Main` validates choices; `DeliveryApplication` renders both components and runs delivery through the contracts.
- `docs`: UML source diagrams in PlantUML format.

## Build and run

On Windows PowerShell, from the repository root:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac --release 17 -d out -sourcepath src/main/java src/main/java/app/Main.java
java -cp out app.Main ROAD WINDOWS
```

On macOS or Linux, use the same `javac` and `java` commands after `mkdir -p out`.

Both choices are required. The first is `ROAD` or `SEA`; the second is `WINDOWS` or `MACOS`. Choices are case-insensitive. Missing or unsupported choices print an error and stop without running a delivery. `MACOS` selects simulated macOS components on any operating system.

## Sample run

```text
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment by road to Aktau warehouse
```

## Verification

Run `ROAD WINDOWS`, `SEA WINDOWS`, `ROAD MACOS`, and `SEA MACOS`. Also run `AIR WINDOWS`, `ROAD LINUX`, and a command with no choices. The actual results are recorded in `docs/verification.txt`.

The README build command and all seven checks were verified with Eclipse Temurin JDK 17.0.20.1.

## Submitted version

The exact submitted commit is listed in the accompanying PDF report. Run `git rev-parse HEAD` to check the current checkout.

The repository is intended as an understandable learning example. Review every method and adapt the report to your own explanations before submitting it as individual work.
