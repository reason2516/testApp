package com.patterns.creational.simplefactory;

public class Factory {
    public static Product createProduct(String name) {
        Product product;
        switch (name) {
            case "productA":
                product = new ProductA();
                break;
            case "productB":
                product = new ProductB();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return product;
    }
}
