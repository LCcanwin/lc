package com.lc.day;

import java.util.concurrent.Semaphore;

/**
 * @Auther: luochao
 * @Date: 2020/12/3
 * @Description:
 */
public class ConsumerProduce {
    static Semaphore queue = new Semaphore(5);

    public static void main(String[] args) {
        Thread produce = new Thread(() -> {
            while (true) {
                System.out.println("生产者开始生产");
                queue.release();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                System.out.println("消费者开始消费");
                try {
                    queue.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        produce.start();
        consumer.start();
    }
}
