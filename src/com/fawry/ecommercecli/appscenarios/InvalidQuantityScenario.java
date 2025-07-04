package com.fawry.ecommercecli.appscenarios;

import com.fawry.ecommercecli.products.Product;
import com.fawry.ecommercecli.products.TV;
import com.fawry.ecommercecli.roles.Customer;
import com.fawry.ecommercecli.services.CheckoutService;

public class InvalidQuantityScenario {
    public static void run(){
        Customer cust = new Customer("Omar", "12345678", "someone@email.com", 50000);
        Product tv = new TV("Samsung 55 inch", 12000, 7, 4000);
        try {
            cust.addItem(tv, 0);
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
