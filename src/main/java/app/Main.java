package app;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;
import java.util.Locale;

public class Main {
    private static final String CARGO = "laboratory equipment";
    private static final String DESTINATION = "Aktau warehouse";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Expected two choices: ROAD or SEA, then WINDOWS or MACOS.");
            return;
        }

        String deliveryMode = args[0].toUpperCase(Locale.ROOT);
        String platform = args[1].toUpperCase(Locale.ROOT);

        try {
            Logistics logistics = selectLogistics(deliveryMode);
            GUIFactory guiFactory = selectGuiFactory(platform);
            System.out.println("Delivery mode: " + deliveryMode);
            System.out.println("UI platform: " + platform);
            new DeliveryApplication(guiFactory, logistics).run(CARGO, DESTINATION);
        } catch (IllegalArgumentException error) {
            System.err.println(error.getMessage());
        }
    }

    private static Logistics selectLogistics(String mode) {
        return switch (mode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> throw new IllegalArgumentException(
                "Unsupported delivery mode: " + mode + ". Use ROAD or SEA.");
        };
    }

    private static GUIFactory selectGuiFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException(
                "Unsupported UI platform: " + platform + ". Use WINDOWS or MACOS.");
        };
    }
}
