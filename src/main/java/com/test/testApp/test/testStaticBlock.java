package com.test.testApp.test;

public class testStaticBlock {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);
    }

    static {
        x /= 3;
    }
}
