package com.test.testApp.test.classLoader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

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
                resolveClass(aClass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return aClass;
    }
}
