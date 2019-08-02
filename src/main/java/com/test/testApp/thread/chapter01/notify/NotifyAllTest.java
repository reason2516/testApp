package com.test.testApp.thread.chapter01.notify;

/**
 * 现象与notifyTest不同 程序能全部执行完毕 原因 notifyAll能唤醒全部线程
 */
public class NotifyAllTest {
    private static volatile Object objectA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t01 = new Thread(() -> {
            synchronized (objectA) {
                try {
                    System.out.println("thread01 is wait");
                    objectA.wait();
                    System.out.println("thread01 be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t02 = new Thread(() -> {
            synchronized (objectA) {
                try {
                    System.out.println("thread02 is wait");
                    objectA.wait();
                    System.out.println("thread02 be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t03 = new Thread(() -> {
            synchronized (objectA) {
                System.out.println("thread03 begin notify");
                objectA.notifyAll();
                System.out.println("thread03 over");
            }
        });
        t01.start();
        t02.start();
        Thread.sleep(100);
        t03.start();

        t01.join();
        t02.join();
        t03.join();
        System.out.println("main thread is over");
    }
}
