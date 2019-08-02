package com.test.testApp.thread.chapter01.deadlock;

/**
 * 死锁:
 * 死锁原因
 * thread01 持有 object01的监视器锁, 同时尝试请求 object02的监视器锁
 * thread02 持有 object02的监视器锁, 同时尝试请求 object01的监视器锁
 */
public class DeadLockTest {
    private static final Object object01 = new Object();
    private static final Object object02 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            synchronized (object01) {
                System.out.println(Thread.currentThread() + " get object01");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " want's get object02 ...");
                synchronized (object02) {
                    System.out.println(Thread.currentThread() + " get object02");
                }
            }
        });

        Thread thread02 = new Thread(() -> {
            synchronized (object02) {
                System.out.println(Thread.currentThread() + " get object02");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " want's get object01 ...");
                synchronized (object01) {
                    System.out.println(Thread.currentThread() + " get object01");
                }
            }
        });

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();

        System.out.println("main thread is over");
    }
}
