package org.example.multiThread;

/**
 * 线程控制1：
 * Thread提供了让一个线程等待另一个线程完成的方法：
 * join（）方法
 * 以下：
 * 主方法开启时，有两条线程运行:main 和 新线程
 * 当主方法运行到i == 20 时，main线程进入等待，此时有两条线程运行 新线程 和 被Join的线程
 * 当 被Join的线程 运行完毕后，main再次运行
 * 
 * 其它的线程有：setDemon yield sleep setPriority(int newPriority)更改优先级
 * 
 * 线程同步：
 * Synchronized(同步代码块，同步方法）:wait notify notifyAll 
 * （ Lock lock = new ReentrantLock()) conditional :await signal signalAll
 */
public class JoinThread extends Thread{
    public JoinThread(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if(i == 20){
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
