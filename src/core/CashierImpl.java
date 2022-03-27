package core;

import models.Clothing;
import repositories.Cart;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CashierImpl implements Cashier {
    private Cart cart;
    private String dateAndTime;

    public CashierImpl(Cart cart, String dateAndTime) {
        this.cart = cart;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public void printReceipt() throws ParseException {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Date: %s", dateAndTime))
                .append(System.lineSeparator())
                .append("---Products---")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(System.lineSeparator());


        int i = 0;
        for (Clothing product : cart.getProducts()) {

            sb.append(product.getName()).append(" - ").append(product.getBrand()).append(System.lineSeparator())
            .append("$").append(product.getPrice()).append(System.lineSeparator()).append(System.lineSeparator());

            if (getDiscountAmount(product) != 0) {
                sb.append(String.format("#discount %.0f%% -$%.2f", getDiscountPercent(product), getDiscountAmount(product)))
                        .append(System.lineSeparator()).append(System.lineSeparator());

                if (++i != cart.getProducts().size()) {
                    sb.append(System.lineSeparator());
                }
            }
        }

        sb.append("-----------------------------------------------------------------------------------")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(String.format("SUBTOTAL: $%.2f", getTotalSum()))
                .append(System.lineSeparator())
                .append(String.format("DISCOUNT: -$%.2f", getTotalDiscount(cart)))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(String.format("TOTAL: $%.2f", getTotalSum() - getTotalDiscount(cart)));

        System.out.println(sb.toString().trim());

    }

    private String dayOfWeek(String dateAndTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

        Date date = formatter.parse(dateAndTime);

        DateFormat formatter2 = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        return formatter2.format(date);
    }

    private double getTotalSum() {
        return cart.getProducts().stream().mapToDouble(Clothing::getPrice).sum();
    }

    private double getDiscountPercent(Clothing product) throws ParseException {
        double discountPercent = 0.00;

        if (dayOfWeek(dateAndTime).equals("Tuesday")) {
            if (product.getClass().getSimpleName().equals("Shoes")) {
                discountPercent = 25;
            } else if (cart.getProducts().size() < 3 && product.getClass().getSimpleName().equals("Shirt")) {
                discountPercent = 10;
            } else if (cart.getProducts().size() >= 3) {
                discountPercent = 20;
            }
        } else if (cart.getProducts().size() >= 3) {
            discountPercent = 20;
        }

        return discountPercent;

    }

    private double getDiscountAmount(Clothing product) throws ParseException {
        return (Math.round((product.getPrice()) * getDiscountPercent(product)) / 100.0);
    }

    private double getTotalDiscount(Cart cart) throws ParseException {
        double totalDiscount = 0.00;
        for (Clothing model : cart.getProducts()) {
            totalDiscount += getDiscountAmount(model);
        }

        return totalDiscount;
    }
}
