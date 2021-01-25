package com.example.javajdk.proxy;


/**
 * 目标类
 */
public class HelloImpl implements HelloService {


    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
