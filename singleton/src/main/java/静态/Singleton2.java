package 静态;

/**
 * @Author: liang
 * @Date: 2021/4/7 0:35
 */
public class Singleton2 {
    private Singleton2(){}

    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
