package com.fawry.ecommercecli.roles;

import com.fawry.ecommercecli.exceptions.InvalidQuantityException;
import com.fawry.ecommercecli.exceptions.NoSuchItemException;
import com.fawry.ecommercecli.products.Product;
import com.fawry.ecommercecli.services.ShoppingCartService;

public class Customer extends Account{
    private ShoppingCartService shoppingCart;
    double balance;
    public Customer(String name, String phoneNumber, String email,double balance){
        super(name, phoneNumber, email);
        this.balance = balance;
        this.shoppingCart = new ShoppingCartService();
    }
    public double getBalance(){
        return this.balance;
    }
    public void balanceCharge(double amount){
        this.balance += amount;
    }
    public void deduceBalance(double amount){
        this.balance -= amount;
    }
    public void addItem(Product item, int quantity) throws InvalidQuantityException{
        this.shoppingCart.addToCart(item, quantity);
    }
    public void removeItem(Product item, ShoppingCartService.Removed removedQuantity) throws NoSuchItemException{
        this.shoppingCart.removeFromCart(item, removedQuantity);
    }
    public ShoppingCartService getCart(){
        return this.shoppingCart;
    }
}
