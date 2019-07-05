package com.jvm;

public class TestSturct {
    public static int staticInt = 0;
    public int testInt = 0;

    static {
        staticInt = 100;
        System.out.println("static block is running now staticInt is " + staticInt);
    }

    {
        this.testInt = 200;
        System.out.println("construct block is running now testInt is " + this.testInt);
    }

    public TestSturct() {
        this.testInt = 300;
        System.out.println("construct function is running now testInt is " + this.testInt);
    }

    public static void main(String[] args) {
        TestSturct testSturct = new TestSturct();
    }
}
