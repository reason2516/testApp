package com.test.testApp.exception;

public class Test {
    public static void main(String[] args)
    {
        int re = bar();
        System.out.println(re);
    }
    private static int bar()
    {
        try{
            return 5;
        } finally{
            System.out.println("finally");
        }
    }
}
