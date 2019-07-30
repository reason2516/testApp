package com.test.testApp.test.jvmError;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {
    static List<TestOOM> list = new ArrayList<>();

    public static void main(String[] args) {
        fun01();
//        fun02();
    }

    public static void fun01() {
        fun01();
    }

    public static void fun02() {
        while (true)
            list.add(new TestOOM());
    }
}
