package com.example.javajdk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {
    public static void main(String[] args) throws IOException {

        test4();
    }

    /**
     * 数据写入文件
     *
     * @throws IOException
     */
    public static void test1() throws IOException {
        File file = new File("c/a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);  //任意的文本编译器，打开的时候会查询编码表，把字节变成字符

        fileOutputStream.write(97);//写数据的时候会把十进制转换为二进制/
        fileOutputStream.close();
    }

    /**
     * 一次写多个字节
     */
    public static void test2() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test2.txt");
        String s = "hello";
        byte[] arr = s.getBytes();
        fileOutputStream.write(arr);
        fileOutputStream.close();
    }

    /**
     * append  追加写开关，true在文件的末尾追加数据
     *
     * @throws IOException
     */
    public static void test3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test3.txt", true);
        String s = "hello";
        byte[] arr = s.getBytes();
        fileOutputStream.write(arr);
        fileOutputStream.close();
    }


    /**
     * 文件复制
     * 1 创建一个字节输入流对象，构造方法中绑定要读取的数据源
     * 2 创建一个字节输入流对象，构造方法中绑定写入的目的地
     * 3 使用字节输入流的read()读取文件
     * 4 使用字节输出流的write(),把读取到的字节写入到目标文件
     * 5 释放资源（先关闭写的流，后关闭读的流）
     *
     * @throws IOException
     */
    public static void test4() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("test4.txt");
        byte[] arr = new byte[1024]; //存取读到的多个字节
        int len  = fileInputStream.read(arr);//从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中    len读取的有效字节个数
        int length = 0;
        while ((length = fileInputStream.read(arr)) != -1) {
            fileOutputStream.write(arr, 0, length);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }


}
