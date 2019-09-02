package com.test.testApp.test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestString {

    public static void main(String[] args) {

        String[] sArr = new String[]{"bcd","cde"};
        System.out.println(longestCommonPrefix(sArr));
//        String s1 = "123";
//        String s2 = "2355";
//        System.out.println(s2.indexOf(s1));
//        String str1 = "0123456789";
//        System.out.println(str1.substring(0,1));
//        String str1 = "aa" + "bb";
//        String str = "aabb";
//        System.out.println(str == str1);

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

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                // 字符串截取最后一位
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
