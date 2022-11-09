package org.example.collectionsTest;

import java.util.*;

/**
 * Collections提供了如下三类方法来返回一个不可变的集合：
 * emptyXxx() 返回一个空的、不可变的集合对象，此处的集合既可以是List,也可以是set,还可以是Map
 * singletonXxx() 
 * unmodifiableXxx()返回指定集合对象的不可变视图，此处的集合既可以是List,也可以是set,还可以是Map
 */
public class TestUnmodifiable {
    public static void main(String[] args) {
        List<Object> unmodifiableList = Collections.emptyList();
        Set<String> unmodifiableSet = Collections.singleton("AAA");

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("语文",89);
        hm.put("数学",97);

        Map<String, Integer> unmodifiableHashMap = Collections.unmodifiableMap(hm);
        
        
        hm.put("英文",20);
        System.out.println(hm);
        
        //以下会报java.lang.UnsupportedOperationException异常
        unmodifiableHashMap.put("物理",99);
        System.out.println(unmodifiableHashMap);
    }
}
