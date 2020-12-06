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

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        TestCallable callable = new TestCallable();
        Future<Integer> result = executor.submit(callable);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
