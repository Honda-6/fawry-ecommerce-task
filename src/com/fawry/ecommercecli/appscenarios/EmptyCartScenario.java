package com.fawry.ecommercecli.appscenarios;

import com.fawry.ecommercecli.roles.Customer;
import com.fawry.ecommercecli.services.CheckoutService;

public class EmptyCartScenario {
    public static void run() {
        Customer cust = new Customer("Mahmoud", "12345678", "mahmoudismail@email.com", 50030);
        try {
            CheckoutService.checkout(cust);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
