package com.fawry.ecommercecli.appscenarios;

import java.time.LocalDate;

import com.fawry.ecommercecli.products.Cheese;
import com.fawry.ecommercecli.products.Product;
import com.fawry.ecommercecli.products.ScratchCard;
import com.fawry.ecommercecli.products.TV;
import com.fawry.ecommercecli.roles.Customer;
import com.fawry.ecommercecli.services.CheckoutService;
import com.fawry.ecommercecli.services.ShoppingCartService;

public class RemoveNonExistingItemFromCartScenario {
    public static void run(){
        Product tv = new TV("Samsung 55 inch", 12000, 7, 4000);
        Product cheese = new Cheese("White Cheese", 80, 6, LocalDate.of(2025, 7, 12), 250);
        Product scratchCard = new ScratchCard("Xbox Card", 200, 20, "dahigfwerefds");
        Customer cust = new Customer("Mohamed", "99999999", "final@email.com", 120000);
        try {
            cust.addItem(tv, 3);
            cust.addItem(cheese, 2);
            cust.removeItem(scratchCard, ShoppingCartService.Removed.ONE);
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
