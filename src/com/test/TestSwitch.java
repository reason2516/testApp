package com.test;

public class TestSwitch {
    public static void main(String[] args) {
        float a = 1 - 0.9f;
        float b = 0.9f - 0.8f;
        double c = 1 - 0.9;
        double d = 0.9 - 0.8;
        if (a == b) {
            System.out.println(11);
        }
//        testFun(null);
    }

    public static void testFun(String str) {
        switch (str) {
            case "a":
                System.out.println(str);
                break;
            default:
                System.out.println(str);
        }
    }
}
