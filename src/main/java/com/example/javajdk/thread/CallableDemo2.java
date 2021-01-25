package com.example.javajdk.thread;

import java.util.concurrent.Callable;

public class CallableDemo2 implements Callable {


    @Override
    public Integer call() throws Exception {
        System.out.println("222222222222222222"+Thread.currentThread().getName());
        return 2;
    }
}
