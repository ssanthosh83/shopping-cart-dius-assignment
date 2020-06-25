package org.santhosh.computerstore.models;

import java.util.Objects;

public class Product {
    private String sku;
    private String name;
    private Double price;
    private Double discountedPrice;

    public Product(String sku, String name, Double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.discountedPrice = 0.0;
    }

    public Product(Sku sku){
        this.sku = sku.toString();
        this.name = sku.getDescription();
        this.price = sku.getPrice();
        this.discountedPrice = 0.0;
    }

    public String getSku() {
        return sku;
    }


    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discountedPrice, product.discountedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, discountedPrice);
    }
}
