package com.jvm;

public class TestJvm {
    public int a;
    public static int num = 0;
    public static int staticVar;

    static {
        staticVar = 100;
        System.out.println("static{} already execute");
    }

    {
        a++;
        num++;
        System.out.println("{} execute funRef num is: " + a);
        System.out.println("{} execute now num is: " + num);
    }

    public static void main(String[] args) {
        int i = 0;
        while (i< 10) {
            new TestJvm();
            i++;
        }
    }

}
