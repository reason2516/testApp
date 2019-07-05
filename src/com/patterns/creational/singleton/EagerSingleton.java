package com.patterns.creational.singleton;

/**
 * 饿汉模式 类加载就创建实例
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 封闭构造方法
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
