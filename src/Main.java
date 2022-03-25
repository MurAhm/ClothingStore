import core.Cashier;
import core.CashierImpl;
import models.*;
import repositories.Cart;


import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {

        Shoe shoe = new Shoe("Black Leather Shoes", "BrandS", 59.99, 43, "black");

        Shirt shirt = new Shirt("Blue Cotton Shirt", "BrandS", 14.99, "M", "blue");

        Shirt shirt2 = new Shirt("White Cotton Shirt", "BrandS", 15.99, "M", "white");

        Jacket jacket = new Jacket("Black Cotton Suit Jacket", "BrandJ", 99.99, 50, "black");

        Trousers trousers = new Trousers("Black Cotton Trousers", "BrandT", 29.99, 50, "black");

        Cart cart = new Cart();
        cart.add(shirt);
        cart.add(shirt2);
        cart.add(trousers);
        cart.add(shoe);
        cart.add(jacket);

        Cashier cashier = new CashierImpl(cart, "2022-02-02 12:34:56");

        cashier.print();


    }
}
