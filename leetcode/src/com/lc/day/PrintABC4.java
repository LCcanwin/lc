package com.lc.day;

import java.util.concurrent.Semaphore;

/**
 * @Auther: luochao
 * @Date: 2020/12/3
 * @Description:
 */
public class PrintABC4 {
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            while (true) {
                try {
                    semaphoreA.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread B = new Thread(() -> {
            while (true) {
                try {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        Thread C = new Thread(() -> {
            while (true) {
                try {
                    semaphoreC.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C");
        A.start();
        B.start();
        C.start();
    }
}
