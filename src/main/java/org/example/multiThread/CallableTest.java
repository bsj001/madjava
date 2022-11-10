package org.example.multiThread;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        RtnThread rt = new RtnThread();
        FutureTask<Integer> task = new FutureTask<>(rt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 循环变量i的值 ："+i);
            if(i == 20){
                new Thread(task,"有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值:"+task.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class RtnThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (;i<100;i++){
            System.out.println(Thread.currentThread().getName() + " 循环变量i的值 ："+i);
        }
        return i;
    }
}
