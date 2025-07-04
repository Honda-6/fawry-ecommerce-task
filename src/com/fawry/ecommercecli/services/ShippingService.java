package com.fawry.ecommercecli.services;

import java.util.HashMap;
import java.util.Map;

import com.fawry.ecommercecli.products.*;


public class ShippingService {
    private Map<Product,Integer> items;
    private double totalWeight = 0;
    public ShippingService(Map <Product,Integer>productList){
        this.items = new HashMap<>(productList);
        for(var order: this.items.entrySet()){
            if(order.getKey() instanceof ShippableProduct){
                ShippableProduct product = (ShippableProduct) order.getKey();
                this.totalWeight += product.getWeight();
            }
        }
    }
    public double shippingFees(){
        if(this.totalWeight > 10000.0)
            return 100;
        return 30;
    }
    public void shippingSummary(){
        System.out.println("\n==Shipping Details==");
        for(var order: this.items.entrySet()){
            if(order.getKey() instanceof ShippableProduct){
                ShippableProduct product = (ShippableProduct) order.getKey();
                System.out.printf("%dx %-15s %10.2fg\n", order.getValue(),product.getName(),product.getWeight());
            }
        }
        System.out.printf("%-18s %10.2fg\n","Total Weight: ",this.totalWeight);
    }
}