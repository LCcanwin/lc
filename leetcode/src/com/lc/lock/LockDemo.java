package com.lc.lock;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义lock
 */
public class LockDemo {

    //锁状态
    private volatile int state = 0;
    //持有锁的当前线程
    private Thread currentThread;
    //基于队列实现公平锁
    private ConcurrentLinkedDeque<Thread> queue = new ConcurrentLinkedDeque<>();

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizer.class.getDeclaredField("state"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public boolean compareAndSwap(int oldValue, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, oldValue, update);
    }

    public void setCurrentThread(Thread thread) {
        this.currentThread = thread;
    }

    public Thread getCurrentThread() {
        return currentThread;
    }

    public int getState() {
        return state;
    }

    public void lock() {
        if (tryAcquire()) {
            return;
        }
        Thread t = Thread.currentThread();
        queue.add(t);
        for (; ; ) {
            //如果队列头部等于当前线程就去拿锁【实现公平】
            if (queue.peek() == t && tryAcquire()) {
                //加锁成功， 从队列中弹出已经加锁成功的线程
                queue.poll();
                return;
            }
            LockSupport.park();
        }
    }

    public void unlock() {
        int state = getState();
        if (getCurrentThread() == Thread.currentThread() && compareAndSwap(state, 0)) {
            setCurrentThread(null);
            Thread first = queue.peek();
            if (first != null) {
                //释放锁后，需要唤醒队列中的线程
                LockSupport.unpark(first); 
            }
        }
    }

    public boolean tryAcquire() {
        Thread t = Thread.currentThread();
        if (getState() == 0) {
            //queue.peek() == t 针对于自旋获取锁
            if ((queue.size() == 0 || queue.peek() == t) && compareAndSwap(0, 1)) {
                setCurrentThread(t);
                return true;
            }
        }
        return false;
    }

}
