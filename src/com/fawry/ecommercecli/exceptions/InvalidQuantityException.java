package com.fawry.ecommercecli.exceptions;

import com.fawry.ecommercecli.products.Product;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(Product product, int quantity){
        super("Invalid quantity entered: " + quantity + " quantities of " + product.getProductName());
    }
}
