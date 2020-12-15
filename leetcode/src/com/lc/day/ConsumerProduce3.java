package com.lc.day;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: luochao
 * @Date: 2020/12/14
 * @Description:
 */
public class ConsumerProduce3 {
    public final int MAX_SIZE = 10;
    public int num = 0;
    public BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
    static ReentrantLock lock = new ReentrantLock();
    static Condition full = lock.newCondition();
    static Condition empty = lock.newCondition();

    public void Produce() throws InterruptedException {
        lock.lock();
        while (queue.size() != MAX_SIZE) {
            System.out.println("生产者生产了：" + num);
            queue.add(num);
            num++;
            Thread.sleep(100);
        }
        System.out.println("生产者达到最大！");
        empty.signal();
        try {
            full.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void Consumer() throws InterruptedException {
        lock.lock();
        while (queue.size() != 0) {
            Thread.sleep(100);
            System.out.println("消费者消费了：" + queue.poll());
        }
        System.out.println("消费者消费完了");
        full.signal();
        try {
            empty.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public static class ThreadProduce implements Runnable {
        public ConsumerProduce3 consumerProduce3;

        public ThreadProduce(ConsumerProduce3 consumerProduce3) {
            this.consumerProduce3 = consumerProduce3;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    consumerProduce3.Produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadConsumer implements Runnable{
        public ConsumerProduce3 consumerProduce3;
        public ThreadConsumer(ConsumerProduce3 consumerProduce3) {
            this.consumerProduce3 = consumerProduce3;
        }
        @Override
        public void run() {
            for (;;){
                try {
                    consumerProduce3.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsumerProduce3 consumerProduce3 = new ConsumerProduce3();
        new Thread(new ThreadProduce(consumerProduce3)).start();
        new Thread(new ThreadConsumer(consumerProduce3)).start();
    }

}
