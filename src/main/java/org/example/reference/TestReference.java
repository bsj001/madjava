package org.example.reference;

import java.lang.ref.WeakReference;

/**
 * 对象的软，弱，虚 引用
 */
public class TestReference {
    public static void main(String[] args) {
        //创建一个字符中对象
        String str = new String("Structs2权威指南");
        //创建一个弱引用，让此弱引用引用到"Structs2权威指南"字符串
        WeakReference<String> wr = new WeakReference<>(str);
        //切断str引用和"Structs2权威指南"字符串之间的引用
        str = null;
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        //再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }
}
