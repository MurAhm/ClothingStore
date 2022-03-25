import core.Cashier;
import core.CashierImpl;
import models.*;
import repositories.Cart;


import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {

        //Example 1

//        Shoes shoes = new Shoes("Black Leather Shoes", "BrandS", 59.99, 43, "black");
//
//        Shirt shirt = new Shirt("Blue Cotton Shirt", "BrandS", 14.99, "M", "blue");
//
//        Shirt shirt2 = new Shirt("White Cotton Shirt", "BrandS", 15.99, "M", "white");
//
//        Jacket jacket = new Jacket("Black Cotton Suit Jacket", "BrandJ", 99.99, 50, "black");
//
//        Trousers trousers = new Trousers("Black Cotton Trousers", "BrandT", 29.99, 50, "black");
//
//        Cart cart = new Cart();
//        cart.add(shirt);
//        cart.add(shirt2);
//        cart.add(trousers);
//        cart.add(shoes);
//        cart.add(jacket);
//
//        Cashier cashier = new CashierImpl(cart, "2022-02-02 12:34:56");





//      Example 2
//
//        Shirt shirt = new Shirt("Black Silk Shirt", "BrandS", 29.99, "L", "black");
//        Shirt shirt2 = new Shirt("White Silk Shirt", "BrandS", 29.99, "L", "white");
//
//
//        Cart cart = new Cart();
//        cart.add(shirt);
//        cart.add(shirt2);
//
//        Cashier cashier = new CashierImpl(cart, "2022-02-01 12:34:56");




        //Example 3
        //

        Shoes shoes = new Shoes("Red Suede Shoes", "BrandS", 59.99, 44, "red");

        Shoes shoes2 = new Shoes("Black Suede Shoes", "BrandS", 59.99, 44, "black");

        Shirt shirt = new Shirt("White Linen Shirt", "BrandS", 29.99, "L", "white");

        Jacket jacket = new Jacket("Red Linen Suit Jacket", "BrandJ", 99.99, 56, "red");

        Trousers trousers = new Trousers("Red Linen Trousers", "BrandT", 49.99, 56, "red");

        Cart cart = new Cart();
        cart.add(trousers);
        cart.add(shoes);
        cart.add(shoes2);
        cart.add(jacket);
        cart.add(shirt);

        Cashier cashier = new CashierImpl(cart, "2022-02-01 12:34:56");

        cashier.printReceipt();


    }
}
