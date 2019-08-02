package com.test.testApp.thread.chapter01.wait.demo;

public class Producer implements Runnable {
    private final Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            int i = 0;
            while (true) {
                if (queue.size() == Queue.MAX_SIZE) {
                    try {
                        i = 0;
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 增加一个元素
                queue.add("Test" + i);
                i++;
                // 通知其他线程
                queue.notifyAll();
            }
        }
    }
}
