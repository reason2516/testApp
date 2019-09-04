package com.test.testApp;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class testInstanceOf {
    public volatile static int x;
    public static void main(String[] args) {
        Map<Object, Object> map = new LinkedHashMap<>();
        System.out.println(map instanceof Map); // 判断实现了某接口的实例
        System.out.println(map instanceof HashMap); // 判断是否为某类的子类的实例
        System.out.println(map instanceof LinkedHashMap); // 判断实例
    }
}
