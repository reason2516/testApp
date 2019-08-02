package com.test.testApp.thread.chapter01.create;

public class CreateByThread {
    /**
     * 必须继承thread
     */
    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a new thread is running");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new CreateByThread().new MyThread();
        myThread.start();
        System.out.println("the main thread is running");
    }
}
