package io.github.w3code.tests;

public enum ToolItems {
    DEWALT("DeWALT DCS551B", "DeWALT DCS551B 20V 20 Volt Li-Ion Max Cordless Rotary Drywall Cut-out Tool"),
    MILWAUKEE("Milwaukee 2810-20", "Milwaukee 2810-20 M18 18V 18 Volt FUEL Mud Mixer"),
    MAKITA("Makita XWT15Z", "Makita XWT15Z 18V LXT Lithium?Ion Brushless Cordless");

    private final String brand;
    private final String title;

    ToolItems(String brand, String title) {
        this.brand = brand;
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public String getTitle() {
        return title;
    }

}
