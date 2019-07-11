package com.test.testApp.test.classLoader;

import java.util.Timer;
import java.util.TimerTask;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().getContextClassLoader().loadClass("com.test.classLoader.DemoClass");
        Thread.currentThread().getContextClassLoader().loadClass("com.test.classLoader.DemoClass");

        ClassLoader myClassLoader = new MyClassLoader();

        new Timer().schedule(new TimerTask() {
                    ClassLoader taskMyClassLoader = new MyClassLoader();
            @Override
            public void run() {
                try {
                    taskMyClassLoader.loadClass("com.test.classLoader.DemoClass").newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
//        Object instance = myClassLoader.loadClass("com.test.classLoader.DemoClass").newInstance();
//
//        ClassLoader classLoader1 = instance.getClass().getClassLoader();
//        ClassLoader classLoader2 = DemoClass.class.getClassLoader();
//        ClassLoader mainClassLoader = TestMain.class.getClassLoader();
//
//        System.out.println(classLoader2 == classLoader1);
//        System.out.println();
//        System.out.println(instance.getClass());
//        System.out.println(instance instanceof com.test.classLoader.DemoClass);
    }
}
