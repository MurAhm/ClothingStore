package models;

import java.util.ArrayList;
import java.util.List;

public class Shirt extends BaseClothing {

    private static final List<String> SHIRT_SIZES = new ArrayList<>(List.of("XS", "S", "M", "L", "XL", "2XL"));
    private String shirtSize;

    public Shirt(String name, String brand, double price, String shirtSize, String color) {
        super(name, brand, price, color);
        this.setShirtSize(shirtSize);
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        if (SHIRT_SIZES.contains(shirtSize)) {
            this.shirtSize = shirtSize;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size:" + this.getShirtSize() + ".\n";
    }
}
