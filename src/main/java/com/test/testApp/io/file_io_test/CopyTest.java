package com.test.testApp.io.file_io_test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class CopyTest {
    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
        String originPath = "C:\\Users\\manager\\Desktop\\copyTest";
        String distPath = "C:\\Users\\manager\\Desktop\\copyTest1";
        copyTest.copy(originPath, distPath);
    }

    public void copy(String originFilePath, String distFilePath) {
        File originFile = new File(originFilePath);
        File distFile = new File(distFilePath);

        if (!originFile.exists()) {
            throw new RuntimeException("originFile not exists");
        }
        if (distFile.exists()) {
            throw new RuntimeException("distance file already exists [" + distFile.getAbsolutePath() + "]");
        }
        copyByFiles(originFile, distFile);

        if (originFile.isDirectory()) {
            // 先创建文件夹
            boolean mkdir = distFile.mkdir();

            // 拷贝子文件
            File[] files = originFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    copy(file.getAbsolutePath(), distFile.getAbsolutePath() + File.separator + file.getName());
                }
            }
        } else {
//            copyBySteam(originFile, distFile);
            copyByFiles(originFile, distFile);
//            copySingleFileByChannel(originFile, distFile);
        }
    }

    /**
     * 方法1
     * channel nio的方式
     */
    public void copySingleFileByChannel(File originFile, File distFile) {
        FileChannel originChannel = null;
        FileChannel distChannel = null;

        try {
            originChannel = new FileInputStream(originFile).getChannel();
            distChannel = new FileOutputStream(distFile).getChannel();
            distChannel.transferFrom(originChannel, 0, originChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法2
     * 通过 Files
     *
     * @param originFile
     * @param distFile
     */
    public void copyByFiles(File originFile, File distFile) {
        try {
            Files.copy(originFile.toPath(), distFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法3
     * 通过 FileStream
     *
     * @param originFile
     * @param distFile
     */
    public void copyBySteam(File originFile, File distFile) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(originFile);
            outputStream = new FileOutputStream(distFile);
            byte[] buffer = new byte[1024];
            int num;
            while ((num = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, num);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
