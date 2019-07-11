package com.test.testApp.test.classLoader;

public class TestMain02 {
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();

        // Application ClassLoader （parent是：Extension ClassLoader）
        ClassLoader classLoader01 = demoClass.getClass().getClassLoader();

        // Null 其实是 Bootstrap ClassLoader
        ClassLoader classLoader02 = "abc".getClass().getClassLoader();

        // Application ClassLoader （parent是：Extension ClassLoader）
        ClassLoader classLoader03 = TestMain02.class.getClassLoader();

        System.out.println(1 == 1);

    }
}
