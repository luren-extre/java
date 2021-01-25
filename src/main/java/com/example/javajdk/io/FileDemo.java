package com.example.javajdk.io;

import java.io.File;
import java.io.IOException;

/**
 * File 是文件和目录路径名的抽象表示
 * <p>
 * 构造方法
 * File(String pathName) // 路径名称；可以以文件结尾，也可以以文件夹结尾；可以是相对路径，也可以是绝对路径
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        test1();
    }

    public static void test1() throws IOException {
        File file = new File("filea.txt");
        if (file.exists()) {
            System.out.println(file.isFile());
        }
    }
}
