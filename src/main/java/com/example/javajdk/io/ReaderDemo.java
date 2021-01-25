package com.example.javajdk.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输入流流  Reader 字符输入流的顶层方法，是自负出入流的最顶层方法，定义了一些共性的抽象方法，是一个抽象类

 * FileReader extends InputStreamReader extends Reader
 * 构造器：FileReader(String fileName)   文件路径
 *       FileReader(File file)         文件
 * 使用步骤：
 *  1 创建FileReader对象，构造方法中绑定要读取的数据
 *  2 使用FileReader对象的read()读取文件
 *  3 释放资源

 *  ==================================================================================
 *
 *
 * 字符输出流 Writer
 *
 * FileWriter extends OutputStreamWriter extends Writer    把内存中的文件写入到文件中
 * 构造器 FileWriter(File file)
 *       FileWriter(String fileName)
 *   作用：1 会创建一个FileWriter对象
 *        2 会根据构造方法中传递的文件/文件路径，创建文件
 *        3 会把FileWriter对象指向创建好的文件
 *  使用步骤：
 *     1 创建FileWriter对象，构造方法中绑定要写入数据的目的地
 *     2 使用FileWriter对象的write()，把数据写入到内存缓冲区中(字节转换为字符的过程)
 *     3 使用FileWriter对象的flush(), 把内存缓冲区的数据刷新到文件中
 *     4 释放资源

 ==================================================================================

 flush()与close区别
  1 flush() 刷新缓冲区，流对象可以继续使用
  2 close() 先刷新缓冲区，然后通知系统释放资源，流对象不可以再被使用了




 */
public class ReaderDemo {

    public static void main(String[] args) throws IOException {
        test2();
    }

    /**
     * 使用字符流读取文件
     * @throws IOException
     */
    public static void test1() throws IOException {
        FileReader fileReader = new FileReader("a.txt");
        char[] arr = new char[1024];
        int length = 0;
        while ((length = fileReader.read(arr)) != -1) {
            System.out.println(new String(arr, 0, length));
        }
    }


    public static void test2() throws IOException {
        FileWriter fileWriter = new FileWriter("write.txt");
        fileWriter.write("abcdefg");
        //fileWriter.flush();
        fileWriter.close();

    }
}
