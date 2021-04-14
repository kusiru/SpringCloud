package 饿汉式;

/**
 * 饿汉式
 * @Author: liang
 * @Date: 2021/4/7 0:23
 */
public class Singleton {

    /**
     * 1、私有化构造器
     */
    public Singleton(){}

    /**
     * 2、自行创建，并且用静态变量保存
     */
    private static final Singleton SINGLETON_1 = new Singleton();

    /**
     * 3、向外提供这个实例
     */

    public static Singleton getInstance() {
        return SINGLETON_1;
    }

}
