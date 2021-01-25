package com.example.javajdk.proxy;

import java.lang.reflect.Proxy;

/**
 *
 */
public class InvokerHandlerTest {

    public static void main(String[] args) {
        HelloService helloService = new HelloImpl();
        MyInvokerHandler invokerHandler = new MyInvokerHandler(helloService);
        /**
         * 创建代理对象
         *
         *  1 目标对象的类加载器
         *  2 目标对象实现的接口
         *  3 我们自己编写的代理类
         * @return
         */
        HelloService proxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), invokerHandler);
        proxy.sayHello();
    }

}
