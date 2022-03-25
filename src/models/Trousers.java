package models;

import java.math.BigDecimal;

import static common.ConstantMessages.*;

public class Trousers extends  BaseClothing{
    private int trousersSize;
    public Trousers(String name, String brand, double price, int trousersSize, String color ) {
        super(name, brand, price, color);
        this.setTrousersSize(trousersSize);
    }

    public int getTrousersSize() {
        return trousersSize;
    }

    public void setTrousersSize(int trousersSize) {
        if(trousersSize < 42 || trousersSize > 66) {
            throw new IllegalArgumentException(WRONG_TROUSERS_SIZE);
        } else if(trousersSize % 2 != 0) {
            throw new IllegalArgumentException(WRONG_TROUSERS_SIZE_ODD_NUMBER);
        } else {
            this.trousersSize = trousersSize;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Size:" + this.getTrousersSize()+ ".\n";
    }
}

