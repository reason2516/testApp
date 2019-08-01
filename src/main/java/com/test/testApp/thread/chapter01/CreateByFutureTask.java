package com.test.testApp.thread.chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateByFutureTask {
    /**
     * 注: FutureTask 实现了runnable 它的run方法调用 callable的call方法,获取到返回值并暂存起来
     * get 方法是阻塞的,监听 FutureTask的状态
     */
    class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            System.out.println("callable is running");
            return "callable is finish";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> ft = new FutureTask<>(new CreateByFutureTask().new MyCallable());
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println("the main thread is running");
        try {
            String s = ft.get();
            System.out.println("the futureTask callable return is " + s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


}
