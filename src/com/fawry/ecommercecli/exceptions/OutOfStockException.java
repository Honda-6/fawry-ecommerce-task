package com.fawry.ecommercecli.exceptions;

import com.fawry.ecommercecli.products.Product;

public class OutOfStockException extends Exception {
    public OutOfStockException(Product product){
        super("Not enough in stock for " + product.getProductName());
    }
}
