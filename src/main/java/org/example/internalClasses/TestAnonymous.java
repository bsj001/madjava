package org.example.internalClasses;

/**
 * 最常用的创建匿名内部类的方式是需要创建某个接口类型的对象
 */
interface Product{
    public double getPrice();
    public String getName();
}
public class TestAnonymous {
    public void test(Product p){
        System.out.println("购买了一个"+p.getName()+",花掉了"+p.getPrice());
    }
    
    public static void main(String[] args){
        TestAnonymous ta = new TestAnonymous();
        //调用test方法时，需要传入一个Product参数，此处传入其匿名实现类的实例
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }
            @Override
            public String getName(){
                return "AGP显卡";
            }
        });
    }
}
