package com.fawry.ecommercecli.appscenarios;

import java.time.LocalDate;

import com.fawry.ecommercecli.products.Cheese;
import com.fawry.ecommercecli.products.Product;
import com.fawry.ecommercecli.products.ScratchCard;
import com.fawry.ecommercecli.products.TV;
import com.fawry.ecommercecli.roles.Customer;
import com.fawry.ecommercecli.services.CheckoutService;

public class InsufficientFundScenario {
    public static void run(){
        Customer cust = new Customer("Ali", "12345678", "someemail@email.com", 50000);
        Product tv = new TV("Samsung 55 inch", 12000, 7, 4000);
        Product cheese = new Cheese("Blue Cheese", 60, 4, LocalDate.of(2025, 7, 5), 200);
        Product scratchCard = new ScratchCard("GiftCard", 200, 10, "dahigfwerefds");
        try {
            cust.addItem(tv, 5);
            cust.addItem(cheese, 2);
            cust.addItem(scratchCard, 3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            CheckoutService.checkout(cust);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
