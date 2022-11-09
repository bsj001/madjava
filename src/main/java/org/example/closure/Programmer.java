package org.example.closure;

interface Teachable{
    void work();
}

public class Programmer {
    private String name;
    public Programmer(){}
    public Programmer(String name){
        this.name = name;
    }
    
    public void work(){
        System.out.println(name+"在灯下认真敲键盘...");
    }
    
    public class TeachableProgrammer extends Programmer implements Teachable{
        public void work(){
            System.out.println();
        }
    }
}
