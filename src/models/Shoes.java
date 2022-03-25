package models;

public class Shoes extends BaseClothing {
    private int shoesSize;

    public Shoes(String name, String brand, double price, int shoesSize, String color) {
        super(name, brand, price, color);
        this.setShoesSize(shoesSize);

    }

    public int getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(int shoesSize) {
        if (shoesSize >= 39 && shoesSize <= 46) {
            this.shoesSize = shoesSize;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size:" + this.getShoesSize() + ".\n";
    }
}
