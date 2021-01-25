package com.example.javajdk.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testThreadAndRunnable();

    }

    /**
     * 调用Thread类的start()方法
     * start()先判断线程当前的状态，然后调用本地方法native(),然后native()启动线程，执行run()中的任务逻辑
     */
    public static void testThread() {
        ThreadDemo1 demo1 = new ThreadDemo1();
        ThreadDemo2 demo2 = new ThreadDemo2();
        ThreadDemo3 demo3 = new ThreadDemo3();
        demo1.start();
        demo2.start();
        demo3.start();
        System.out.println("!!!!!!!!!!!!" + Thread.currentThread().getName());
    }

    /**
     * Runnable实现多线程
     * <p>
     * java语言中只能单继承，通过实现接口的方式，可以让实现类去继承其它类。而直接继承thread就不能再继承其它类了；
     * <p>
     * 线程控制逻辑在Thread类中，业务运行逻辑在Runnable实现类中。解耦更为彻底；
     * <p>
     * 实现Runnable的实例，可以被多个线程共享并执行。而实现thread是做不到这一点的。
     */
    public static void testRunnable() {
        Thread demo1 = new Thread(new RunnableDemo1());
        Thread demo2 = new Thread(new RunnableDemo2());
        Thread demo3 = new Thread(new RunnableDemo3());
        demo1.start();
        demo2.start();
        demo3.start();
        System.out.println("!!!" + Thread.currentThread().getName());
    }


    /**
     * Thread也实现了Runnable接口。Thread类的run方法上有@Override注解
     *
     * 继承thread类实现多线程，其实也相当于是实现runnable接口的run方法
     */
    public static void testThreadAndRunnable() {
        Thread thread1 = new Thread(new ThreadDemo1());
        Thread thread2 = new Thread(new ThreadDemo2());
        Thread thread3 = new Thread(new ThreadDemo3());
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static void test1() throws ExecutionException, InterruptedException {

        FutureTask futureTask1 = new FutureTask(new CallableDemo1());

        FutureTask futureTask2 = new FutureTask(new CallableDemo2());

        FutureTask futureTask3 = new FutureTask(new CallableDemo3());
        FutureTask futureTask4 = new FutureTask(new CallableDemo2());
        FutureTask futureTask5 = new FutureTask(new CallableDemo2());
        FutureTask futureTask6 = new FutureTask(new CallableDemo2());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        executorService.submit(futureTask3);
        executorService.submit(futureTask4);
        executorService.submit(futureTask5);
        executorService.submit(futureTask6);
        System.out.println(futureTask1.get().toString());

    }


}
