package com.test.testApp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestString {

    public static void main(String[] args) {
        String str1 = "aa" + "bb";
        String str = "aabb";
        System.out.println(str == str1);

//        Object o = null;
//        System.out.println("this is "+ o);
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//            }
//        };
//        thread.start();
//        int value = 1024;
//    abstract class a{}
//        List<int[]> ints = Arrays.asList(new int[]{1, 2, 3});
//        ArrayList<int[]> ints1 = new ArrayList<int[]>(Arrays.asList(new int[]{1, 2, 3}));
//
//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4}));
////        String[] strArr = {"123", "aaa", null, "", "123"};
////        String join = StringUtils.join(Arrays.asList(strArr), ",");
////        System.out.println(join);
////        String str = "com.fanghuwang.dangan.AAA.class";
////        String substring = str.substring(str.lastIndexOf(".") + 1);
////        System.out.println(substring);
////        String a = "ab";
////        String b = "funRef"+"b";
////        if(a == b){
////            System.out.println(123);
////        }
////        System.out.println(a==b);
////        ((Integer) null).equals(1);
//        int count = 0;
//        for (int num = 1; num <= 1000; num++) {
//            if (isZero(num)) {
//                count++;
//            }
//        }
//        System.out.println(count);
    }

    public static boolean isZero(int num) {

        while (num != 0) {
            int ret = num % 10;
            if (ret == 0) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
}
