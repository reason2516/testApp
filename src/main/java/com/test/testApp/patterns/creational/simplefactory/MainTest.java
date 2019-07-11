package com.test.testApp.patterns.creational.simplefactory;

public class MainTest {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("productA");
        Product productB = Factory.createProduct("productB");
//        Product productC = Factory.createProduct("productC");
        productA.selfMethod();
        productB.selfMethod();
    }
}
