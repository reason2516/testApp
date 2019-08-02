package com.test.testApp.thread.chapter01.wait.demo;

public class WaitTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread threadP = new Thread(producer);
        Thread threadC = new Thread(consumer);
        threadP.start();
        threadC.start();

    }
}
