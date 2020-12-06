package com.lc.day;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: luochao
 * @Date: 2020/12/3
 * @Description:
 */
public class ConsumerProduce2 {
    private static int length = 10;
    private static AtomicLong num = new AtomicLong(0);
    private static Queue<Long> queue = new LinkedList<>();

    public static void main(String[] args) {
        Object object = new Object();
        Thread produce = new Thread(() -> {
            synchronized (object) {
                while (true) {
                    if (queue.size() < length) {
                        num.incrementAndGet();
                        System.out.println("生产者生产了商品编号" + num.get());
                        queue.add(num.get());
                    } else {
                        try {
                            Thread.sleep(1000);
                            object.notifyAll();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (object) {
                while (true) {
                    if (queue.size() > 0) {
                        System.out.println("消费者消费了商品编号" + queue.poll());
                    } else {
                        try {
                            Thread.sleep(1000);
                            object.notifyAll();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        produce.start();
        consumer.start();
    }
}
