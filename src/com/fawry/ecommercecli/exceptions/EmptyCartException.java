package com.fawry.ecommercecli.exceptions;

import com.fawry.ecommercecli.roles.Account;

public class EmptyCartException extends Exception{
    public EmptyCartException(Account user){
        super(user.getName() + " has an empty Cart!!\nCannot checkout.");
    }
}
