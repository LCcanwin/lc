package com.lc.day;

import java.util.concurrent.Semaphore;

/**
 * @Auther: luochao
 * @Date: 2020/12/3
 * @Description: 基于信号量做买票场景
 */
public class BuyCard {
    //假定五个购票窗口
    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        //100人开始买
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("开始购买票中。。" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("买票结束。。" + Thread.currentThread().getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
