package com.test.testApp.patterns.creational.simplefactory;

public class Factory {
    public static Product createProduct(String name) {
//        Product product;
        if ("A".equalsIgnoreCase(name))
            return new ProductA();
        else if ("B".equalsIgnoreCase(name))
            return new ProductB();
        else
            throw new IllegalArgumentException();


//        switch (name) {
//            case "productA":
//                product = new ProductA();
//                break;
//            case "productB":
//                product = new ProductB();
//                break;
//            default:
//                throw new IllegalArgumentException();
//        }
//        return product;
    }
}
