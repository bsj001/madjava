package org.example.multiThread;

/**
 * 线程组
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字:"+mainGroup.getName());
        System.out.println("主线程组是否是后台线程组:"+
                            mainGroup.isDaemon());
        new TestThread("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg线程组是否是后台线程组:"+tg.isDaemon());
        TestThread tt = new TestThread(tg, "tg线程组的线程甲");
        tt.start();
        new TestThread(tg,"tg线程组的线程乙").start();
    }
}

class TestThread extends Thread{
    public TestThread(String name){
        super(name);
    }
    
    public TestThread(ThreadGroup group,String name){
        super(group,name);
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " 线程的i变量" + i);
        }
    }
}
