package org.example.treeMap;

import java.util.WeakHashMap;

/**
 * 运行结果：
 * {java=中等, 数学=及格, 英语=中等, 语文=良好}
 * {java=中等}
 * 说明：当系统进行垃圾回收时，删除了WeakHashMap对象的前三个key-value对。这是因为添加了前三个key-value对，这三个key
 * 都是匿名字符串对象，只有WeakHashMap保留了对它们的弱引用。WeakHashMap对象中的第四组key-value对的key是一个字符串直接量，
 * 系统会缓存这个字符串直接量（即系统保留了对该字符串对象的强引用），所以垃圾回收时不会回收它。
 *  
 */
public class TestWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<String,String> whm = new WeakHashMap<String,String>();
        
        whm.put(new String("语文"),new String("良好"));
        whm.put(new String("数学"),new String("及格"));
        whm.put(new String("英语"),new String("中等"));
        
        whm.put("java",new String("中等"));
        System.out.println(whm);
        
        //垃圾回收
        System.gc();
        System.runFinalization();
        
        System.out.println(whm);
        
        //强制删除
        whm.remove("java");
        System.out.println(whm);
    }
}
