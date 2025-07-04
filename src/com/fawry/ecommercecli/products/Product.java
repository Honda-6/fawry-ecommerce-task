package com.fawry.ecommercecli.products;

public abstract class Product {
    private String name;
    private double price;
    private int stock;
    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public double getPrice(){
        return this.price;
    }
    protected String getProductName(){
        return this.name;
    }
    public int getStock(){
        return this.stock;
    }
    public void addToStock(int amount){
        this.stock += amount;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void getQuantity(int amount){
        this.stock -= amount;
    }
}
