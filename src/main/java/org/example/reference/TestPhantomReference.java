package org.example.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class TestPhantomReference {
    public static void main(String[] args) {
        //创建一个字符中对象
        String str = new String("Structs2权威指南");
        //创建一个引用队列
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        //创建一个虚引用，让此弱引用引用到"Structs2权威指南"字符串
        PhantomReference<String> pr = new PhantomReference<>(str, rq);
        //切断str引用和"Structs2权威指南"字符串之间的引用
        str = null;
        System.out.println(pr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        //再次取出弱引用所引用的对象
        System.out.println(rq.poll() == pr);
        
    }
}
