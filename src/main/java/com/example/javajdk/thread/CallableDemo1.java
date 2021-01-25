package com.example.javajdk.thread;

import java.util.concurrent.Callable;

public class CallableDemo1 implements Callable {


    @Override
    public String call() throws Exception {
        System.out.println("aaaaaaaa" + Thread.currentThread().getName());
        return "true";
    }
}
