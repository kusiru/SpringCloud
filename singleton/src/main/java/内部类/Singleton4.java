package 内部类;

/**
 * 适用于多线程
 * 静态内部类不会随着外部类的加载和初始化而初始化，调用时才会去加载和初始化
 * @Author: liang
 * @Date: 2021/4/7 0:50
 */
public class Singleton4 {

    private Singleton4(){}

    private static class Inner{
        private static final Singleton4 SINGLETON_4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Inner.SINGLETON_4;
    }
}