package com.fawry.ecommercecli.role;

public abstract class Account {
    private String name, phoneNumber, email;
    
    public Account(String name,String number, String email){
        this.name = name;
        this.phoneNumber = number;
        this.email = email;
    }
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getEmail(){
        return this.email;
    }
    public void changeName(String name){
        this.name = name;
    }
    public void changeNumber(String number){
        this.phoneNumber = number;
    }
    public void changeEmail(String email){
        this.email = email;
    }
}