package com.example.javajdk;

/**
 *
 *  基本类型作为参数是值传递
 *  基本类型作为返回值，返回的是值
 *
 *  引用类型作为参数是引用传递（地址传递）
 *  引用类型作为返回值，返回的是地址
 *
 */
public class Argument {
    public static void main(String[] args) {
        int n = 10;
        test(n);
        System.out.println(n);
    }

    public static void test(int v) {
        v = 20;

    }
}
