package com.test.testApp.thread.chapter01.wait.demo;

public class Consumer implements Runnable {
    private final Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                if (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 消费一个元素
                queue.take();
                // 通知其他线程
                queue.notifyAll();
            }
        }
    }
}
