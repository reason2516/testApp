package com.test.testApp.thread.chapter01.wait;

public class WaitInterrupt {
    private static final Object o = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (o) {
                try {
                    System.out.println("new thread is wait");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 子线程开始执行
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 子线程被中断 因为子线程是wait中 所以抛出异常
        thread.interrupt();
    }
}
