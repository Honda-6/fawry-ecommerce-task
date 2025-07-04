package com.fawry.ecommercecli.products;

import java.time.LocalDate;

public class Biscuits extends Product implements PerishableProduct {
    private double weight;
    private LocalDate expiryDate;
    public Biscuits(String name,double price, int stock, LocalDate expirationDate, double weight){
        super(name, price, stock);
        this.expiryDate = expirationDate;
        this.weight = weight;
    }
    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }
    @Override
    public void setExpiryDate(LocalDate date) {
        this.expiryDate = date;
    }
    @Override
    public String getName() {
        return this.getProductName();
    }
    @Override
    public double getWeight() {
        return this.weight;
    }
}
