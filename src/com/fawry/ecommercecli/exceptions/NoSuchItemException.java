package com.fawry.ecommercecli.exceptions;

import com.fawry.ecommercecli.products.Product;

public class NoSuchItemException extends Exception {
    public NoSuchItemException(Product product){
        super(product.getProductName() + " doesn't exist in the shopping cart!!");
    }
}
