package com.test.testApp.test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * 方案1 强制转型
     *
     * @param
     */
    public static void test01() {
        String testStr = "111,222,";
        List<String> arrayList = new ArrayList<>();
        String[] testStrSplits = testStr.split(",");
        for (String testStrSplit : testStrSplits) {
            if (!arrayList.contains(testStrSplit)) {
                arrayList.add(testStrSplit);
            }
        }

        for (Object o : arrayList) {
            String outStr = (String) o;
            System.out.println(outStr);
        }
    }

    /**
     * 方案02 List泛型
     */
    public static void test02(){
        String testStr = "444,666,";
        ArrayList<String> arrayList = new ArrayList<>();
        String[] testStrSplits = testStr.split(",");
        for (String testStrSplit : testStrSplits) {
            if (!arrayList.contains(testStrSplit)) {
                arrayList.add(testStrSplit);
            }
        }

        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public static void testDateFormater(){
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format();
//        DateTimeFormatter formatter = new DateTimeFormatter();

    }
}
