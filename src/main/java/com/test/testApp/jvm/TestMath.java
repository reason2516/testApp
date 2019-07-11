package com.test.testApp.jvm;

public class TestMath {

    public int math() {
        int a = 6;
        int b = 2;

        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        TestMath testMath = new TestMath();
        testMath.math();
    }
}
