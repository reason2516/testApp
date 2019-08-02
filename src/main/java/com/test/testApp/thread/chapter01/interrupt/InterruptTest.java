package com.test.testApp.thread.chapter01.interrupt;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread() + " not interrupted");
            }
            System.out.println(Thread.currentThread() + " is interrupted");
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt(); // 中断
    }
}
