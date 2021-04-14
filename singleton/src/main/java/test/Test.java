package test;

import 懒汉式.Singleton3;
import 枚举.EnumSingleton;
import 静态.Singleton2;
import 饿汉式.Singleton;

/**
 * @Author: liang
 * @Date: 2021/4/7 0:31
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE);
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton2.getInstance());


        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton31 = Singleton3.getInstance();
        System.out.println(singleton3 == singleton31);
    }
}
