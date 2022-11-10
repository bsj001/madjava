package org.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPollTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.shutdown();
    }
}

class TestThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"的i值是:"+i);
        }
    }
}
