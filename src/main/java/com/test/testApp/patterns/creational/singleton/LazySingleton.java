package com.test.testApp.patterns.creational.singleton;

/**
 * 懒汉模式 - 双重锁加
 */
public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {
        // 封闭构造方法
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            // 当多个线程并发时 同时进入了 上面的if语句 分配锁后，只有一个线程能执行该代码块
            synchronized (LazySingleton.class) {
                // 第1个分配到锁的线程 此时 instance 为null 执行创建动作
                // 第n(n>1)个分配到锁的线程 此时 instance不为null 不执行创建 （注：要用volatile关键字修饰 instance）
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
