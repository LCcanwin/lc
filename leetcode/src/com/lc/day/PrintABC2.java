package com.lc.day;


public class PrintABC2 {
    static volatile boolean threadA = true;
    static volatile boolean threadB = false;
    static volatile boolean threadC = false;
    static Thread A, B, C;

    public static void main(String[] args) {
        Object o = new Object();
        A = new Thread(() -> {
            synchronized (o) {
                while (true) {
                    if (threadA) {
                        System.out.println(Thread.currentThread().getName());
                        threadA = false;
                        threadB = true;
                        threadC = false;
                        o.notifyAll();
                    }else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "A");

        B = new Thread(() -> {
            synchronized (o) {
                while (true) {
                    if (threadB) {
                        System.out.println(Thread.currentThread().getName());
                        threadA = false;
                        threadB = false;
                        threadC = true;
                        o.notifyAll();
                    }else {
                        try {
                            o.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, "B");

        C = new Thread(() -> {
            synchronized (o) {
                while (true) {
                    if (threadC) {
                        System.out.println(Thread.currentThread().getName());
                        threadC = false;
                        threadB = false;
                        threadA = true;
                        o.notifyAll();
                    }else {
                        try {
                            o.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, "C");
        A.start();
        B.start();
        C.start();
    }
}
