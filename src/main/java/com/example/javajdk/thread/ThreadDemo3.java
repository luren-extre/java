package com.example.javajdk.thread;

public class ThreadDemo3 extends Thread{



    @Override
    public void run() {
        System.out.println("-----------------"+Thread.currentThread().getName());
    }

}
