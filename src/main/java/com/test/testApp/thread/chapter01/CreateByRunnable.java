package com.test.testApp.thread.chapter01;

public class CreateByRunnable {

    /**
     * 必须实现 runnable方法
     */
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the new thread is running");
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new CreateByRunnable().new MyRunnable();

        // 使用的时候借助 thread对象 作为 thread对象的参数
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("the main thread is running");
    }
}
