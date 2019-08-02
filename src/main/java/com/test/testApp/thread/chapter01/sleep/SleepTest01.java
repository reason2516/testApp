package com.test.testApp.thread.chapter01.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 无论执行多少次 结果都一样  因为 sleep 不会释放锁,所以线程1,2的执行 不会出现交替
 */
public class SleepTest01 {
    // 独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            // 获取独占锁
            lock.lock();
            System.out.println("thread01 is sleep");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread01 is aweaked");

            // 释放独占锁
            lock.unlock();
        });
        Thread thread02 = new Thread(() -> {
            // 获取独占锁
            lock.lock();
            System.out.println("thread02 is sleep");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread02 is aweaked");

            // 释放独占锁
            lock.unlock();
        });

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();
        System.out.println("main thread is over");
    }
}
