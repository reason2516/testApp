package com.test.testApp.test;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<Character,Character> map = new HashMap<>();
        map.put('c','d');
        boolean c = map.containsKey('c');
        System.out.println(c);


//        Map<String, String> map = new LinkedHashMap<>();
//
//        map.put("001","001");
//        map.put("001","001");
//        map.put("002","002");
//        map.put("003","003");
//
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println("requestId is: "+ entry.getKey() + " projectNo is: " + entry.getValue());
//        }

//        Hashtable<Object, Object> has = new Hashtable<>();
//        has.put(null, "123");

//        HashMap<Object, Object> hm = new HashMap<>();
//        hm.put(null,"111");

//        TreeMap<Object, Object> tm = new TreeMap<>();
//        tm.put(1,null);

    }
}
