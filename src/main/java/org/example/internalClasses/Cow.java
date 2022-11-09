package org.example.internalClasses;

/**
 * 类的成员变量：
 * 属性
 * 方法
 * 初始化块 ： 静态 + 非静态
 * 成员内部类 ： 静态 + 非静态
 * 非成员： 匿名内部类 -> 外部类
 *         局部内部类 -> 方法内
 * 
 */

public class Cow {
    private double weight;
    public Cow(){}
    public Cow(double weight){
        this.weight = weight;
    }
    
    //定义一个非静态内部类
    private class CowLeg{
        //非静态内部类的两个属性
        private double length;
        private String color;
        public CowLeg(){}
        public CowLeg(double length,String color){
            this.length = length;
            this.color = color;
        } 
        public void setLength(double length){
            this.length = length;
        }
        public double getLength(){
            return this.length;
        }
        public void setColor(String color){
            this.color = color;
        }
        public String getColor(){
            return this.color;
        }
        
        //非静态内部类的实例方法
        public void info(){
            System.out.println("当前牛腿颜色是:"+color+",高："+length);
            //直接访问外部类的private属性：weight
            System.out.println("本牛腿所在奶牛重："+weight);
        }
    }
    
    public void test(){
        CowLeg cl = new CowLeg(1.12, "黑白相间");
        cl.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(378.9);
        cow.test();
    }   
}
