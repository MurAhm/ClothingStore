package models;

import java.math.BigDecimal;

public abstract class BaseClothing implements Clothing{
    private String name;
    private String brand;
    private double price;
    private String color;

    protected BaseClothing(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + "\n" +
        "Brand:" + this.brand + "\n" +
                "Price:" + this.price + "\n" +
                "Color:" + this.color + "\n";
    }
}
