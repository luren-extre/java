package com.example.javajdk.thread;

public class ThreadDemo2 extends Thread{



    @Override
    public void run() {
        System.out.println("==============="+Thread.currentThread().getName());
    }

}
