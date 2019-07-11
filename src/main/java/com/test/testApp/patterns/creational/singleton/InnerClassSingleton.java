package com.test.testApp.patterns.creational.singleton;

/**
 * 静态内部类模式
 * 思路：由于恶汉模式 主类加载的时候就实例化 造成了一定的资源浪费 懒汉模式又过于繁琐且效率低
 * 而静态内部类模式原理是：
 * 静态内部类 只有在使用的时候才会被加载，利用这一特性，将实例化放到静态内部类 延迟实例化单例 达到最理想的效果
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
        // 封闭构造方法
    }

    public static class HolderClass {
        private static InnerClassSingleton instance = new InnerClassSingleton();

        private HolderClass() {

        }

        public static InnerClassSingleton getInstance() {
            return HolderClass.instance;
        }
    }
}
