package com.lc.day;

/**
 * @Auther: luochao
 * @Date: 2020/12/9
 * @Description:
 */
public class Singleton02 {
    private static volatile Singleton02 singleton = null;

    public Singleton02() {
    }

    public static Singleton02 getSingleton() {
        if (singleton == null) { //如果单例为空，避免进入同步代码块，提高效率
            synchronized (Singleton02.class) {
                if (singleton == null) { //这里如果获得锁了，但是突然切换线程了。释放了锁，这时另一个线程也会进来，则会创建两个对象
                    singleton = new Singleton02();
                }
            }
        }
        return singleton;
    }

}
