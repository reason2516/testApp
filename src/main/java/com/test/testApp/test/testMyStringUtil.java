package com.test.testApp.test;

import com.test.testApp.utils.MyStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testMyStringUtil {
    public static void main(String[] args) {
//        case01();
//        case02();
        case03();
    }

    public static void case01() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("123");
        objects.add(null);
        objects.add("456");
        objects.add("888");

//        System.out.println(MyStringUtil.join(objects, ","));
//        System.out.println(MyStringUtil.join(new Object[]{"123",1,1231,null,881,"123",1L,'a'}, ","));
        System.out.println(MyStringUtil.join(new Object[]{}, ","));
    }

    public static void case02() {
        TestClass tc01 = new TestClass();
        tc01.setFieldA("tc01_fa");
        tc01.setFieldB("tc01_fb");
        TestClass tc02 = new TestClass();
        tc02.setFieldA("tc02_fa");
        tc02.setFieldB(null);
        TestClass tc03 = new TestClass();
        tc03.setFieldA("tc03_fa");
        tc03.setFieldB("tc03_fb");
        ArrayList<Object> list = new ArrayList<>();
        list.add(tc01);
        list.add(tc02);
        list.add(tc03);
        System.out.println(MyStringUtil.joinSpecifiedField(list, "fieldB", ","));
    }

    public static void case03(){
        ArrayList<Map> list = new ArrayList<>();
        HashMap<Object, Object> map01 = new HashMap<>();
        map01.put("key01","aaa");
        map01.put("key02","bbb");
        HashMap<Object, Object> map02 = new HashMap<>();
        map02.put("key01","ccc");
        map02.put("key02","ddd");
        HashMap<Object, Object> map03 = new HashMap<>();
        map03.put("key01","eee");
        map03.put("key02","fff");
        list.add(map01);
        list.add(map02);
        list.add(map03);
        System.out.println(MyStringUtil.joinSpecifiedField(list,"key04"," | "));
    }

    public static class TestClass {
        private String fieldA;
        private String fieldB;

        public String getFieldA() {
            return fieldA;
        }

        public void setFieldA(String fieldA) {
            this.fieldA = fieldA;
        }

        public String getFieldB() {
            return fieldB;
        }

        public void setFieldB(String fieldB) {
            this.fieldB = fieldB;
        }
    }
}
