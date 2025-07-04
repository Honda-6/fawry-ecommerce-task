package com.fawry.ecommercecli.products;

import java.time.LocalDate;

public interface PerishableProduct {
    public LocalDate getExpiryDate();
    public void setExpiryDate(LocalDate date);
}
