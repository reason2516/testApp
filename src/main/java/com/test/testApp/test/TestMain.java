package com.test.testApp.test;

public class TestMain {
    public static void main(String[] args) {
        /*
         byte(8),
         short(16),
         int(32),
         long(64),
         char(16),
         float(32),
         double(64),
         boolean,
         数组,
         接口,
         类·,
         */
        char a = 'a'; // 单引号 是char型
        String str = "您好"; // 双引号字符串型
        System.out.println(str);
        int[] b = new int[5];
        b = new int[]{1,2,3,4,5};
        b = new int[]{1,2,3,4,5,7,8};
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
