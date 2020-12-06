package com.lc.thread;


public class TwoThreadRun implements Runnable {

    private static int num = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (num != 0) {
                break;
            }
            if (i == 100) {
                num = 100;
                System.out.println("winner is" + Thread.currentThread().getName());
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    public static void main(String[] args) {
        TwoThreadRun run = new TwoThreadRun();
        Thread t1 = new Thread(run, "兔子");
        Thread t2 = new Thread(run, "乌龟");
        t1.start();
        t2.start();
    }
}
