package com.lc.day;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: luochao
 * @Date: 2020/12/3
 * @Description:
 */
public class PrintABC3 {
    static ReentrantLock lock = new ReentrantLock(true);
    static Condition conditionA = lock.newCondition();
    //相当于定义一个对象锁，使用时
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("A");
                    conditionB.signal();
                    conditionA.await(); //线程阻塞，然后释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock(); //避免死锁
                }
            }
        }, "A");

        Thread B = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("B");
                    conditionC.signal();
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "B");

        Thread C = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("C");
                    conditionA.signal();
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "C");
        A.start();
        B.start();
        C.start();
    }
}
