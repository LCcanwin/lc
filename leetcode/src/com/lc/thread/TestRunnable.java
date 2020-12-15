package com.lc.thread;

import java.util.concurrent.FutureTask;

/**
 * @Auther: luochao
 * @Date: 2020/12/14
 * @Description:
 */
public class TestRunnable implements Runnable{

    public static int sum = 0;
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            sum+=i;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new TestRunnable()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }
        System.out.println(sum);
    }
}
