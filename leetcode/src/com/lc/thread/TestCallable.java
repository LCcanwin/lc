package com.lc.thread;

import java.util.concurrent.*;

/**
 * @Auther: luochao
 * @Date: 2020/12/5
 * @Description:
 */
public class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        TestCallable callable = new TestCallable();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future1 = executor.submit(callable);
        System.out.println(future1.get());
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new Exception(e);
        }
    }
}
