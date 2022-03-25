package models;

import java.math.BigDecimal;

import static common.ConstantMessages.*;

public class Jacket extends  BaseClothing{
    private int jacketSize;
    public Jacket(String name, String brand, double price, int jacketSize, String color) {
        super(name, brand, price, color);
        this.setJacketSize(jacketSize);
    }

    public int getJacketSize() {
        return jacketSize;
    }

    public void setJacketSize(int jacketSize) {
        if(jacketSize < 42 || jacketSize > 66) {
            throw new IllegalArgumentException(WRONG_JACKET_SIZE);
        } else if(jacketSize % 2 != 0) {
            throw new IllegalArgumentException(WRONG_JACKET_SIZE_ODD_NUMBER);
        } else {
            this.jacketSize = jacketSize;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size:" + this.getJacketSize()+ ".\n";
    }
}
