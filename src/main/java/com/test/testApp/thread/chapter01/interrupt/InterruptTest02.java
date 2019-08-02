package com.test.testApp.thread.chapter01.interrupt;

public class InterruptTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) ;
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt(); // 中断

        // isInterrupted true
        System.out.println(thread.isInterrupted());

        // interrupted 注意: interrupted 是一个static方法
        // 因此 thread.interrupted 其实等价于 Thread.interrupted()
        // 所以返回的是主线程的 中断状态 false
        System.out.println(thread.interrupted());

        //返回主线程中断状态 false
        System.out.println(Thread.interrupted());

        // isInterrupted true
        System.out.println(thread.isInterrupted());

        //
        System.out.println(Thread.interrupted());
    }
}
