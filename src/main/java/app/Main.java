package app;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println(
                "Enter delivery mode and platform: ROAD WINDOWS"
            );
            return;
        }

        String deliveryMode = args[0].toUpperCase();
        String platform = args[1].toUpperCase();

        Logistics logistics;

        if (deliveryMode.equals("ROAD")) {
            logistics = new RoadLogistics();
        } else if (deliveryMode.equals("SEA")) {
            logistics = new SeaLogistics();
        } else {
            System.out.println("Use ROAD or SEA.");
            return;
        }

        GUIFactory guiFactory;

        if (platform.equals("WINDOWS")) {
            guiFactory = new WindowsFactory();
        } else if (platform.equals("MACOS")) {
            guiFactory = new MacOSFactory();
        } else {
            System.out.println("Use WINDOWS or MACOS.");
            return;
        }

        System.out.println("Delivery mode: " + deliveryMode);
        System.out.println("UI platform: " + platform);

        DeliveryApplication application =
            new DeliveryApplication(guiFactory, logistics);

        application.run(
            "laboratory equipment",
            "Aktau warehouse"
        );
    }
}
