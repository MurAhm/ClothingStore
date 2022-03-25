package core;

import models.Clothing;
import repositories.Cart;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CashierImpl implements Cashier {
    private final Cart cart;
    private String dateAndTime;

    public CashierImpl(Cart cart, String dateAndTime) {
        this.cart = cart;
        this.dateAndTime = dateAndTime;
    }

    private String dayOfWeek(String dateAndTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

        Date date = formatter.parse(dateAndTime);

        DateFormat formatter2 = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        return formatter2.format(date);
    }


    @Override
    public void print() throws ParseException {
        StringBuilder sb = new StringBuilder();
        double totalSum = 0.00;
        double totalDiscount = 0.00;

        sb.append(String.format("Date: %s", dateAndTime))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("---Products---")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        for (Clothing model : cart.getModels()) {
            double discountPercent = 0.00;
            totalSum += model.getPrice();

            if (dayOfWeek(dateAndTime).equals("Tuesday")) {
                if (model.getClass().getSimpleName().equals("Shoe")) {
                    discountPercent = 25;
                } else if (cart.getModels().size() < 3 && model.getClass().getSimpleName().equals("Shirt")) {
                    discountPercent = 10;
                } else if (cart.getModels().size() >= 3) {
                    discountPercent = 20;
                }
            } else if (cart.getModels().size() >= 3) {
                discountPercent = 20;
            }


            double discount = (Math.round((model.getPrice()) * discountPercent) / 100.0);
            totalDiscount += discount;


            sb.append(model.getName()).append(" - ").append(model.getBrand()).append(System.lineSeparator());
            if (!(model.getClass().getSimpleName().equals("Shirt") && model.getColor().equals("white"))) {
                sb.append(System.lineSeparator());
            }
            sb.append("$").append(model.getPrice()).append(System.lineSeparator());

            if (model.getClass().getSimpleName().equals("Shirt") && model.getColor().equals("blue")) {
                sb.append(System.lineSeparator());
            }

            if (discount != 0) {
                if (model.getClass().getSimpleName().equals("Shirt")) {
                    sb.append(String.format("#discount %.0f%%  -$%.2f", discountPercent, discount))
                            .append(System.lineSeparator()).append(System.lineSeparator());
                    if (model.getColor().equals("blue")) {
                        sb.append(System.lineSeparator());
                    }
                } else {
                    sb.append(String.format("#discount %.0f%% -$%.2f", discountPercent, discount))
                            .append(System.lineSeparator()).append(System.lineSeparator());
                }
            }
        }
        sb.append("-----------------------------------------------------------------------------------")
                .append(System.lineSeparator())
                .append(String.format("SUBTOTAL: $%.2f", totalSum))
                .append(System.lineSeparator())
                .append(String.format("DISCOUNT: -$%.2f", totalDiscount))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(String.format("TOTAL: $%.2f", totalSum - totalDiscount));

        System.out.println(sb.toString().trim());

    }
}
