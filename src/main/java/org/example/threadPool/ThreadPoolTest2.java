package org.example.threadPool;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest2 {
    
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(10,20,0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>());
    
    private static void sleepMethod(int index){
        try{
            long sleepTime = new Double(Math.random()*10000).longValue();
            Thread.sleep(sleepTime);
            System.out.println("当前线程执行结束"+index);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //isTerminated
    @Test
    public void shutdownTest() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int index = i;
            pool.execute(()->sleepMethod(index));
        }
        pool.shutdown();
        while(!pool.isTerminated()){
            Thread.sleep(1000);
            System.out.println("还没停止。。");
        }
        System.out.println("全部执行完毕"); 
    }
    
    //getCompleteTaskCount
    @Test
    public void taskCountTest() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int index = i;
            pool.execute(()->sleepMethod(index));
        }
        //当线程池完成的线程数等于线程池中的总线程数
        while(!(pool.getTaskCount()==pool.getCompletedTaskCount())){
            System.out.println("任务总数："+pool.getTaskCount()+";已经完成的任务数："+pool.getCompletedTaskCount());
            Thread.sleep(1000);
            System.out.println("还没停止....");
        }
        System.out.println("全部执行完毕");
    }
    
    //countDownLatch计数器
    @Test
    public void countDownLatchTest() throws InterruptedException {
        CountDownLatch taskLatch = new CountDownLatch(30);
        for (int i = 0; i < 30; i++) {
            int index = i;
            pool.execute(()->{
                sleepMethod(index);
                taskLatch.countDown();
                System.out.println("当前计数器数量："+taskLatch.getCount());
            });
        }
        //当前纯种阻塞，等待计数器置为0
        taskLatch.await();
        System.out.println("全部执行完毕");
    }
    
    //维护一个公共计数器
    /**
     * 其实就是加锁计数，循环判断
     */
    private static int taskNum = 0;
    
    @Test
    public void countNumTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 30; i++) {
            int index = i;
            pool.execute(()->{
                sleepMethod(index);
                lock.lock();
                taskNum++;
                lock.unlock();
            });
        }
        while (taskNum<30){
            Thread.sleep(1000);
            System.out.println("还没停止。。。");
        }
        System.out.println("全部执行完毕");
    }
    
    //Future判断任务执行状态

    /**
     * Future是用来装载线程结果的，只能装载一条线程的返回结果，很少用来判断任务执行状态
     */
    @Test
    public void futureTaskTest() throws InterruptedException {
        Future<?> future = pool.submit(() -> sleepMethod(1));
        while(!(future.isDone())){
            Thread.sleep(500);
            System.out.println("还没停止。。");
        }
        System.out.println("全部执行完毕");
    }
}
