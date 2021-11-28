package io.github.w3code.tests;

public enum ToolItems {
    DEWALT("dewalt dcd791b", "DEWALT DCD791B 20V 20 Volt 2 Speed Brushless"),
    MILWAUKEE("Milwaukee 2407-20", "Milwaukee 2407-20 NEW M12 12V Li-Ion Cordless"),
    MAKITA("Makita DHP482Z", "Makita DHP482Z 18V LXT Combi Hammer Driver Drill");

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
