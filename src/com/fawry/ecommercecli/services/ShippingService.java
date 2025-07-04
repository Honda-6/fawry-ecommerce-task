package com.fawry.ecommercecli.services;

import com.fawry.ecommercecli.products.*;
import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    private List<ShippableProduct> items;
    public ShippingService(List<ShippableProduct> productList){
        this.items = new ArrayList<>(productList);
        /* for(var item: productList){
            items.add(item);
        } */
    }
    public void shippingSummary(){
        System.out.println("==Shipping Details==");
        for(var item: this.items){
            //TODO: print quantities and weights   
        }
    }
}