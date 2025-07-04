package com.fawry.ecommercecli.exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(){
        super("Empty Cart!!\nCannot checkout.");
    }
}
