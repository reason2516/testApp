package com.test.testApp.io.file_io_test;

import java.io.File;

public class RenameTest {
    public static void main(String[] args) {
        RenameTest renameTest = new RenameTest();
        // 注意事项：
        // 1. 目标地址不存在同名文件
        // 2. 目标分区与源分区再同一分区
        // 思考 如何高效实现重命名 或者 类剪切功能？分区判断？执行系统命令？
        String originName = "C:\\Users\\manager\\Desktop\\renameTest";
        String distName = "C:\\Users\\manager\\Desktop\\renameTest1";
        renameTest.rename(originName, distName);
    }

    public void rename(String originName, String distName) {
        File file = new File(originName);
        File distFile = new File(distName);
        if(!file.exists()){
            throw new RuntimeException("originFile not exists");
        }
        if(distFile.exists()){
            throw new RuntimeException("distName already exists");
        }
        boolean b = file.renameTo(distFile);
    }
}
