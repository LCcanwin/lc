package com.lc.thread;

/**
 * 静态代理
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("3")).start(); //实际上就是静态代理，实现的runnable接口
         new SeverProxy(new Server()).print();
    }

}

interface PrintLog {
    void print();
}

class Server implements PrintLog {
    @Override
    public void print() {
        System.out.println("打印日志");
    }
}

class SeverProxy implements PrintLog {
    private Server server;

    public SeverProxy(Server server) {
        this.server = server;
    }

    @Override
    public void print() {
        before();
        server.print();
        after();
    }

    private void before() {
        System.out.println("日志安全分析");
    }

    private void after() {
        System.out.println("日志存储");
    }
}