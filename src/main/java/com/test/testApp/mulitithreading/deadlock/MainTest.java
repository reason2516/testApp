package com.test.testApp.mulitithreading.deadlock;

public class MainTest {
    public static void main(String[] args) {
        new Thread(new DeadLock(true), "Thread01").start();
        new Thread(new DeadLock(false), "Thread02").start();
    }
}
