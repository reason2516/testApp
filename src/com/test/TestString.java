package com.test;

public class TestString {
    public static void main(String[] args) {
        String str = "com.fanghuwang.dangan.AAA.class";
        String substring = str.substring(str.lastIndexOf(".") + 1);
        System.out.println(substring);
//        String a = "ab";
//        String b = "funRef"+"b";
//        if(a == b){
//            System.out.println(123);
//        }
//        System.out.println(a==b);
    }
}
