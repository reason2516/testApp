package com.test.testApp.test;

public class Test {

    public static void main(String[] args) {
        String strA = "test";
        String strB = "test";
        String strC = new String("test");

        int intA = -0b1111_1111_1111_1111_1111_1111_1111_1111;
        int intB = 145;
        int intC = 0221;
        int intD = 0x91;
        int intE = -145;


        System.out.println(Integer.toBinaryString(intA));
        System.out.println(Integer.numberOfLeadingZeros(intA));
//        System.out.println(strA == strB);
//        System.out.println(strA == strC);
//
//        System.out.println(strA.hashCode());
//        System.out.println(strB.hashCode());
//        System.out.println(strC.hashCode());
//
//        Double b = 1.1;
//        Double c = funRef(b);
//        System.out.println(c);

//        double d = funVal(b);
//        System.out.println();
//        System.out.println(b);
//        String str = "123";
//        String strb = testStr(str);
//        System.out.println(funRef(b));
//        System.out.println(b);
//        System.out.println(strb);
//        System.out.println(str);
    }

    public static Double funRef(Double c) {
        c = c;
        c = c + 2.2;
        return c;
    }

//    public static double funVal(double b) {
//        b=b;
//        b = b + 2.2;
//        return b;
//    }
//    public static String testStr(String str){
//        str =  str+"456";
//        return str;
//    }
}
