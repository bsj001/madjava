package org.example.multiThread;

/**
 * 线程组的异常处理器
 */
public class ExHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int a = 5/0;
    }
}

class MyExHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t,Throwable e){
        System.out.println(t + "线程出现了异常："+ e);
    }
}
