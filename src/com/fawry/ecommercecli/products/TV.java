package com.fawry.ecommercecli.products;

public class TV extends Product implements ShippableProduct {
    private double weight;
    public TV(String name, double price,int stock, double weight){
        super(name, price,stock);
        this.weight = weight;
    }
    @Override
    public String getName(){
        return this.getProductName();
    }
    @Override
    public double getWeight(){
        return this.weight;
    }
}
