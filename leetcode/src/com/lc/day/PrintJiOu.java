package com.lc.day;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintJiOu {
    private ReentrantLock lock = new ReentrantLock();
    private Condition ji = lock.newCondition();
    private Condition ou = lock.newCondition();
    private int num = 0;
    public void printJi() throws InterruptedException {
        lock.lock();
        while (num % 2 == 0) {
            System.out.println("我是偶线程");
            num++;
            Thread.sleep(100);
        }
        ji.signal();
        try {
            ou.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void printOu() throws InterruptedException {
        lock.lock();
        while (num % 2 == 1) {
            System.out.println("我是奇线程");
            num++;
            Thread.sleep(100);
        }
        ou.signal();
        try {
            ji.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    static class ThreadJi implements Runnable{
        PrintJiOu printJiOu;
        public ThreadJi(PrintJiOu printJiOu) {
            this.printJiOu = printJiOu;
        }
        @Override
        public void run() {
            while (true){
                try {
                    printJiOu.printJi();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadOu implements Runnable{
        PrintJiOu printJiOu;
        public ThreadOu(PrintJiOu printJiOu) {
            this.printJiOu = printJiOu;
        }
        @Override
        public void run() {
            while (true){
                try {
                    printJiOu.printOu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintJiOu printJiOu = new PrintJiOu();
        new Thread(new ThreadJi(printJiOu)).start();
        new Thread(new ThreadOu(printJiOu)).start();
    }

}
