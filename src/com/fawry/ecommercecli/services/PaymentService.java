package com.fawry.ecommercecli.services;

import com.fawry.ecommercecli.roles.Account;

public interface PaymentService {
    void pay(Account user, double amount) throws Exception;
}