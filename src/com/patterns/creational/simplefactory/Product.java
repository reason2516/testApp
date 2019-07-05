package com.patterns.creational.simplefactory;

public abstract class Product {
    public void commonMethod() {
        System.out.println("called funRef common method");
    }

    public abstract void selfMethod();
}
