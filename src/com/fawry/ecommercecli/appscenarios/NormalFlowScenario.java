package com.fawry.ecommercecli.appscenarios;

import java.time.LocalDate;

import com.fawry.ecommercecli.products.Cheese;
import com.fawry.ecommercecli.products.Product;
import com.fawry.ecommercecli.products.ScratchCard;
import com.fawry.ecommercecli.products.TV;
import com.fawry.ecommercecli.roles.Customer;
import com.fawry.ecommercecli.services.CheckoutService;


public class NormalFlowScenario {
    public static void run() {
        Product tv = new TV("Samsung 55 inch", 12000, 7, 4000);
        Product cheese = new Cheese("Blue Cheese", 60, 4, LocalDate.of(2025, 7, 5), 200);
        Product scratchCard = new ScratchCard("GiftCard", 200, 10, "dahigfwerefds");
        Customer cust = new Customer("Ahmed", "123214231", "AyHaga@email.com", 100000);
        try {
            cust.addItem(tv, 3);
            cust.addItem(cheese, 2);
            cust.addItem(scratchCard, 3);
            // cust.removeItem(scratchCard, ShoppingCartService.Removed.ONE);
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
