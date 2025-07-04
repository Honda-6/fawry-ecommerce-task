package com.fawry.ecommercecli.role;

public class Customer extends Account{
    //Cart shoppingCart;
    double balance;
    public Customer(String name, String phoneNumber, String email,double balance){
        super(name, phoneNumber, email);
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void balanceCharge(double amount){
        this.balance += amount;
    }
}
