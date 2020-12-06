package com.lc.day;

import java.util.concurrent.locks.LockSupport;

public class PrintABC {
    static Thread A, B, C;

    public static void main(String[] args) {
        A = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                //唤醒B
                LockSupport.unpark(B);
                LockSupport.park();
            }
        }, "A");

        B = new Thread(() -> {
            while (true) {
                //先阻塞，等待被唤醒
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(C);
            }
        }, "B");

        C = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(A);
            }
        }, "C");
        A.start();
        B.start();
        C.start();
    }
}
