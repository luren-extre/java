package com.example.javajdk;

/**
 * 数组
 *
 * 1.
 *
 */
public class JavaArray {
    public static void main(String[] args) {
        int [] a = new int[3];
        System.out.println(a);  //输出的是对象a的hash值
        System.out.println(a.hashCode());
        System.out.println(0x6e0be858);
    }
}
