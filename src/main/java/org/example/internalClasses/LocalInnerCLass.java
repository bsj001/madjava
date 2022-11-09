package org.example.internalClasses;

/**
 * 局部内部类
 * 适合创建那种需要一次使用的类
 * 匿名内部类的语法有点奇怪，创建匿名内部类会立即创建一 个该类的实例，这个类定义立即消失，匿名内部类不能重复使用。
 */
public class LocalInnerCLass {
    public static void main(String[] args) {
        //定义局部内部类
        class InnerBase{
            int a ;
        }
        //定义局部内部类的子类
        class InnerSub extends InnerBase{
            int b;
        }
        //创建局部内部类的对象
        InnerSub is = new InnerSub();
        is.a = 5;
        is.b = 8;
        System.out.println("InnerSub对象的a和b属性是："+is.a+","+is.b);
    }
}
