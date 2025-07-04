package com.fawry.ecommercecli.services;

import java.time.LocalDate;

import com.fawry.ecommercecli.exceptions.*;
import com.fawry.ecommercecli.products.PerishableProduct;
import com.fawry.ecommercecli.roles.Customer;

public class CheckoutService {
    public static void checkout(Customer customer) throws Exception {
        ShoppingCartService customerCart = customer.getCart();

        if(customerCart.getProducts().isEmpty()){
            throw new EmptyCartException();
        }

        for (var pair : customerCart.getProducts().entrySet()) {
            if (pair.getValue() > pair.getKey().getStock()) {
                customer.removeItem(pair.getKey(), ShoppingCartService.Removed.ALL);
                throw new OutOfStockException(pair.getKey());
            }
            if (pair.getKey() instanceof PerishableProduct) {
                PerishableProduct product = (PerishableProduct) pair.getKey();
                if (product.getExpiryDate().isBefore(LocalDate.now()) || product.getExpiryDate().isEqual(LocalDate.now())) {
                    customer.removeItem(pair.getKey(), ShoppingCartService.Removed.ALL);
                    throw new ExpiredProductException(product);
                }
            }
        }

        ShippingService ship = new ShippingService(customerCart.getProducts());
        double subTotal = customerCart.evaluate();
        double fees = ship.shippingFees();
        if (subTotal + fees > customer.getBalance()) {
            throw new InsufficientBalanceException(customer);
        }

        ship.shippingSummary();
        System.out.println("\n==Checkout Summary==");
        System.out.printf("%-18s %10s %20s","Item","Cost", "Total");
        System.out.println("\n---------------------------------------------------");
        for (var order : customerCart.getProducts().entrySet()) {
            order.getKey().getQuantity(order.getValue());
            System.out.printf("%dx %-15s %10.2f %20.2f\n", order.getValue(), order.getKey().getProductName(), order.getKey().getPrice(),order.getKey().getPrice() * order.getValue());
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("Subtotal: %5.2f\n",subTotal);
        System.out.printf("Shipping Fees: %4.2f\n",fees);
        System.out.printf("Total: %6.2f\n",subTotal + fees);
        
        System.out.printf("\n%s's previous Balance: %.2f\n",customer.getName(),customer.getBalance());
        customer.deduceBalance(fees + subTotal);
        System.out.printf("%s's current Balance: %.2f\n",customer.getName(),customer.getBalance());
    }
}
