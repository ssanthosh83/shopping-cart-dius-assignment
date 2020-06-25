package org.santhosh.computerstore.models;

public enum Sku {
    IPD("Super Ipad", 549.99),
    MBP("Macbook Pro", 1399.99),
    ATV("Apple TV", 109.50),
    VGA("VGA Adapter", 30.00);

    private final String description;
    private final Double price;

    Sku(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
