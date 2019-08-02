package com.test.testApp.thread.chapter01.yield;

/**
 * Yield 线程向CPU提出交出时间片 但是有可能CPU还会将时间片再次分配给你当前线程
 */
public class YieldTest implements Runnable {
    public YieldTest() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + " is yield when i == " + i);
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
