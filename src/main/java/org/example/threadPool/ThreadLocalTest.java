package org.example.threadPool;

/**
 * 从运行结果看，main线程 、线程甲、线程乙 三个线程的account的值互不影响
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Account at = new Account("初始名");
        new MyTest(at,"线程甲").start();
        new MyTest(at,"线程乙").start();
    }
}

class Account{
    private ThreadLocal<String> name = new ThreadLocal<>();
    public Account(String str){
        this.name.set(str);
        System.out.println("-------"+this.name.get());
    }
    
    public String getName(){
        return name.get();
    }
    public void setName(String str){
        this.name.set(str);
    }
}

class MyTest extends Thread{
    private Account account;
    public MyTest(Account account,String name){
        super(name);
        this.account = account;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            if(i == 6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户的i值："+i);
        }
        account.setName(null);
    }
}
