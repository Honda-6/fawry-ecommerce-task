package com.fawry.ecommercecli;

import com.fawry.ecommercecli.appscenarios.*;

public class EcommerceApp {
    public static void main(String[] args) {
        System.out.println("Normal flow scenario\n===================================\n");
        NormalFlowScenario.run();
        System.out.println("\n===================================\n");
        System.out.println("\nInsufficient funds scenario\n===================================\n");
        InsufficientFundScenario.run();
        System.out.println("\n===================================\n");
        System.out.println("\nExpired product scenario\n===================================\n");
        ExpiredProductScenario.run();
        System.out.println("\n===================================\n");
        System.out.println("\nEmpty cart scenario\n===================================\n");
        EmptyCartScenario.run();
        System.out.println("\n===================================\n");
        System.out.println("\nRemoving a non-existent element from cart scenario\n===================================\n");
        RemoveNonExistingItemFromCartScenario.run();
        System.out.println("\n===================================\n");
        System.out.println("\nAdding invalid quantites of a product scenario\n===================================\n");
        InvalidQuantityScenario.run();
        System.out.println("\n===================================\n");
    }
    
}