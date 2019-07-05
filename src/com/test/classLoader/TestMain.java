package com.test.classLoader;

import java.io.IOException;
import java.io.InputStream;

public class TestMain {
    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                Class<?> aClass = null;
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);

                if (is == null) {
                    aClass = super.loadClass(name);
                } else {
                    try {
                        byte[] bytes = new byte[is.available()];
                        is.read(bytes);
                        aClass = defineClass(name, bytes, 0, bytes.length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return aClass;
            }
        };


        Object instance = myClassLoader.loadClass("com.test.classLoader.DemoClass").newInstance();

        ClassLoader classLoader1 = instance.getClass().getClassLoader();
        ClassLoader classLoader2 = DemoClass.class.getClassLoader();
        ClassLoader mainClassLoader = TestMain.class.getClassLoader();

        System.out.println(classLoader2 == classLoader1);
        System.out.println();
        System.out.println(instance.getClass());
        System.out.println(instance instanceof com.test.classLoader.DemoClass);
    }
}
