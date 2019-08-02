package com.test.testApp.thread.chapter01.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * InterruptedException 因为: thread01在sleep过程中被中断
 */
public class SleepInterrupt {
    // 独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            System.out.println("thread01 is sleep");

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread01 is aweaked");

        });

        thread01.start();
        Thread.sleep(100);
        thread01.interrupt();
    }
}
