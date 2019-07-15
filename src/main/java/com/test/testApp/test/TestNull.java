package com.test.testApp.test;

public class TestNull {
    public static void testMethod() {
        System.out.println("testMethod running");
    }

    public static void main(String[] args) {
        ((TestNull)null).testMethod();
        TestNull testNull = new TestNull();
        testNull.testMethod();
    }
}
