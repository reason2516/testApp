package com.test.testApp.utils;

public class ArrayUtil {
    public static  String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append("[" + i + " => " + arr[i] + "]\r\n");
        }

        return sb.toString();
    }
}
