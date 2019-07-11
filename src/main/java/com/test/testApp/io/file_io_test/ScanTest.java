package com.test.testApp.io.file_io_test;

import java.io.File;

public class ScanTest {
    public static void main(String[] args) {
        ScanTest traversal = new ScanTest();
        traversal.scanDir("C:\\Users\\manager\\Desktop\\fileTest", "");
    }

    public void scanDir(String path, String prefix) {
        File file = new File(path);
        String newPrefix = prefix + "\t";
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File fileInner : files) {
                System.out.println(prefix + fileInner.getName() + " -> " + fileInner.getAbsolutePath());
                if (fileInner.isDirectory()) {
                    this.scanDir(fileInner.getAbsolutePath(), newPrefix);
                }
            }
        } else {
            System.out.println(file.getAbsolutePath() + "is not exists");
        }
    }
}
