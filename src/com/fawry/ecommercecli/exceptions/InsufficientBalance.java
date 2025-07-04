package com.fawry.ecommercecli.exceptions;

public class InsufficientBalance extends Exception{
    public InsufficientBalance(String message)
    {
        super(message);
    }
}