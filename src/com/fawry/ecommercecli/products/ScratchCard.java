package com.fawry.ecommercecli.products;

public class ScratchCard extends Product {
    private final String scratchCode;
    public ScratchCard(String name, double price, int stock, String code){
        super(name, price, stock);
        this.scratchCode = code;
    }
    public String getScratchCode(){
        return this.scratchCode;
    }
}
