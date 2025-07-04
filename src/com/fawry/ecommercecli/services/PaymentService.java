package com.fawry.ecommercecli.services;

import com.fawry.ecommercecli.role.Account;

public interface PaymentService {
    void pay(Account user, double amount) throws Exception;
}