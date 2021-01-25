package com.example.javajdk.thread;

public class ThreadDemo1 extends Thread{



    @Override
    public void run() {
        System.out.println("**************"+Thread.currentThread().getName());
    }




}
