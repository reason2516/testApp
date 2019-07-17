package com.test.testApp.mulitithreading.deadlock;

public class DeadLock implements Runnable {
    public static final Object o1 = new Object();
    public static final Object o2 = new Object();

    public boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            System.out.println(Thread.currentThread().getName() + " begin running");
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " hold the lock o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " prepare to apply the lock o2");

                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " never execute this line");
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " begin running");
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " hold the lock o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " prepare to apply the lock o1");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " never execute this line");

                }
            }
        }
    }
}
