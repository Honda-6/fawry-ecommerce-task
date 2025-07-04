package com.fawry.ecommercecli.exceptions;

import java.time.LocalDate;

import com.fawry.ecommercecli.products.PerishableProduct;

public class ExpiredProductException extends Exception{
    public ExpiredProductException(PerishableProduct product){
        super(product.getName() + " is already Expired: " + product.getExpiryDate().toString() + "\nCurrentDate: " + LocalDate.now());
    }
}
