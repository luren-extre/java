package com.example.javajdk.jvm;



/**
 * 类的唯一性
 *     对于任意一个类，都需要又加载他的类和这个类本身一同确认java虚拟机中的唯一性
 *     每一个类加载器，都拥有一个独立的名称空间比较两个类是否相等，只有比较这两个类是由同一个类加载器加载的前提下才有意义
 *
 *     每个类加载器的命名空间
 *
 *     类加载器不是继承关系，是包含关系，包含着上层加载器的引用，父加载器是子类加载器的一个属性
 *
 *
 * 用户自定义类加载器
 *    实现： 实现应用隔离，不同的类加载器去加载不同的类
 *
 *
 * 双亲委派机制在loadClass()方法中体现
 *
 *
 * Class.forName() 与 ClassLoader.loadClass()的区别
 *    Class.forName()  是一个静态方法，入参是类的全限定名返回一个Class对象，该方法将在Class文件加载到内存的同时，会执行类的初始化
 *    ClassLoader.loadClass()：这是一个实例方法，需要一个ClassLoader对象来调用该方法，该方法将Class文件加载到内存时，并不会执行类的初始化，知道这个类第一次使用时才进行初始化
 *
 * 双亲委派机制
 *     优势：
 *         1 避免类的重复加载，保证了类的全局唯一性
 *         2 保证程序的安全，防止核心api被篡改
 *
 *     代码支持：(双亲委派机制在2，3步骤中)
 *         1 先在当前类加载器的缓存中查找有无目标类，如果有，直接返回
 *         2 判断当前类加载器的父类加载器是否为null，如果不空，让父类加载器去加载，
 *         3 如果为null，让启动类加载器去加载
 *         4 如果都为空，findClass进行加载，defineClass
 *
 *     劣势：
 *         1 检查类是否加载的委托过程是单向的，顶层的classLoader无法访问底层classLoader所加载的类
 *
 *     破坏双亲委派机制：
 *         1 线程上下文类加载器
 *
 * 自定义类加载器
 *     1  隔离加载类  在框架内部进行中间件和应用的模块隔离，tomcat中隔离同一Web服务器上的不同应用程序
 *     2  扩展加载源  java类型转换时，只有两个类型都是由同一个类加载器所加载，才能进行类型转换
 *
 *    实现方式：
 *        1 重写loadClass方法
 *          双亲委派机制的逻辑所在，避免破坏双亲委派机制
 *        2 重写findClass方法
 */

public class ClassLoaderDemo extends ClassLoader {


    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取扩展累加载器
        ClassLoader extClassLoader = ClassLoaderDemo.class.getClassLoader().getParent().getParent();
        System.out.println("aaa==========="+extClassLoader);

        //获取其上层
        /**
         * BootStrap 类加载器  由C/C++编写
         *
         * 只加载包名为java，javax，sun等开头的包
         *
         * 加载扩展类和应用类类加载器，并指定为扩展类和启动类的类加载器
         */
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println(bootClassLoader);

        //获取用户自定义的类加载
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);

        //当前线程的类加载器
        ClassLoader classLoaderThread = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoaderThread);

    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }
}
