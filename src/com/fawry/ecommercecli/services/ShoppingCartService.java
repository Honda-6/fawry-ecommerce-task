package com.fawry.ecommercecli.services;

import java.util.HashMap;
import java.util.Map;

import com.fawry.ecommercecli.exceptions.InvalidQuantityException;
import com.fawry.ecommercecli.exceptions.NoSuchItemException;
import com.fawry.ecommercecli.products.*;

public class ShoppingCartService {
    private Map<Product, Integer> products;

    public static enum Removed {
        ALL,
        ONE
    }

    public ShoppingCartService() {
        this.products = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) throws InvalidQuantityException{
        if(quantity < 1){
            throw new InvalidQuantityException(product,quantity);
        }
        this.products.merge(product, quantity, Integer::sum);
    }

    public void removeFromCart(Product product, Removed quantity) throws NoSuchItemException {
        if (!products.containsKey(product)) {
            throw new NoSuchItemException(product);
        }
        if (quantity == Removed.ALL) {
            products.remove(product);
        } else {
            if (products.get(product) == 1) {
                products.remove(product);
                return;
            }
            products.put(product, products.get(product) - 1);
        }
    }
    public Map<Product,Integer> getProducts(){
        return this.products;
    }
    public double evaluate() {
        return this.products.keySet()
                .stream()
                .mapToDouble(product -> (product.getPrice() * this.products.get(product)))
                .sum();

    }
}
