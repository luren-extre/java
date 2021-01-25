package com.example.javajdk.thread;

import java.util.concurrent.Callable;

public class CallableDemo3 implements Callable {


    @Override
    public Object call() throws Exception {
        System.out.println("3333333333333"+Thread.currentThread().getName());
        return 3;
    }
}
