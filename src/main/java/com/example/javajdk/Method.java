package com.example.javajdk;

/**
 * 方法
 * <p>
 * 方法签名:方法名和参数类型
 *
 * 方法重载:方法名相同，参数类型不同
 *
 * 栈帧：随着方法的调用而创建，随着方法的结束而销毁，存储了方法的局部变量信息
 */
public class Method {

    public static void main(String[] args) {
        //   sum(1,2,3);
        System.out.println(sum(1, 2, 3));
    }

    /**
     * 可变参数  必须放在最后面
     *
     * @param numbers
     * @return
     */
    public static int sum(int... numbers) {
        int result = 0;
        for (int num : numbers) {
            result = result + num;
        }
        return result;
    }


}
