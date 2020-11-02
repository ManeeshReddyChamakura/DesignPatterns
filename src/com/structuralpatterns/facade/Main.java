package com.structuralpatterns.facade;

class OperatingSystem {
    // state data
    public void loadBIOS() {
        // loads bios
        System.out.println("Loading BIOS...complete");
    }
    public void testHardware() {
        // tests hardware
        System.out.println("testing hardware...complete");
    }
    public void initializeHardware() {
        // initialzie hardware
        System.out.println("initializing hardware...complete");
    }
    public void loadOperationSystem() {
        // bootloader loads the OS
        System.out.println("Loading os...complete");
    }
}

class OperatingSystemFacade {
    public void on() {
        OperatingSystem os = new OperatingSystem();
        os.loadBIOS(); // some parameters would be passed
        os.testHardware();
        os.initializeHardware();
        os.loadOperationSystem();
    }
}



public class Main {
    public static void main(String[] args) {
        // OperatingSystem os = new OperatingSystem();
        // os.loadBIOS(); // some parameters would be passed
        // os.testHardware();
        // os.initializeHardware();
        // os.loadOperationSystem();

        OperatingSystemFacade facade = new OperatingSystemFacade();
        facade.on();
    }
}
