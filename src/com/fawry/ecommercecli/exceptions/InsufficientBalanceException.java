package com.fawry.ecommercecli.exceptions;

import com.fawry.ecommercecli.roles.Account;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(Account user){
        super(user.getName() + " has insufficient funds!!");
    }
}