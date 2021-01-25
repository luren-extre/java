package com.example.javajdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * InvocationHandler  （调用处理器   ）
 * 完成代理类要做的功能（1. 调用目标方法  2.功能增强）
 */
public class MyInvokerHandler implements InvocationHandler {

    private Object target;

    /**
     * 传入目标对象，对其创建代理对象
     * @param target
     */
    public MyInvokerHandler(Object target) {
        this.target = target;
    }

    /**
     * 创建代理对象
     *
     *  1 目标对象的类加载器
     *  2 目标对象实现的接口
     *  3 我们自己编写的代理类
     * @return
     */
    public Object getProxy() {
        Class c = target.getClass();
        return Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), this);
    }




    /**
     * invoke（）代理类需要完成的功能
     *
     * @param proxy  jdk创建的代理对象，
     * @param method 目标类中的方法
     * @param args   目标累中方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用反射机制调用某个方法
        //Method 表示方法
        Object result = method.invoke(target, args);


        return result;
    }
}
