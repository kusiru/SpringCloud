package 懒汉式;

/**
 * 懒汉式：延迟创建这个实例对象
 *
 * @Author: liang
 * @Date: 2021/4/7 0:41
 */
public class Singleton3 {

    /**
     * 1、私有化构造器
     */
    private Singleton3(){}

    private static Singleton3 instance;

    /**
     * 线程不安全，适用单线程
     * @return
     */
    public static Singleton3 getInstance() {
        if (instance == null) {
            instance =  new Singleton3();
        }
        return instance;
    }

    /**
     * 加锁
     * @return
     */
    public static Singleton3 getInstance2() {
        synchronized (instance) {
            if (instance == null) {
                instance =  new Singleton3();
            }
        }
        return instance;
    }

    /**
     * 双重检查
     * @return
     */
    public static Singleton3 getInstance3() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
