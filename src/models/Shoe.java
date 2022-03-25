package models;

import java.math.BigDecimal;

import static common.ConstantMessages.WRONG_SHOE_SIZE;

public class Shoe extends BaseClothing{
    private int shoeSize;


    public Shoe(String name, String brand, double price, int shoeSize, String color ) {
        super(name, brand, price, color);
        this.setShoeSize(shoeSize);

    }



    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        if(shoeSize < 39 || shoeSize > 46) {
            throw new IllegalArgumentException(WRONG_SHOE_SIZE);
        }
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size:" + this.getShoeSize()+ ".\n";
    }
}
