package org.example.treeMap;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap是一个特殊的Map实现，此类实现Map接口时，它有意违反Map的通常规范，
 * IdentityHashMap要求两个key严格相等时才认为两个key相等。
 */
public class TestIdentityHashMap {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> ihm = new IdentityHashMap<>();
        ihm.put(new String("语文"),89);
        ihm.put(new String("数学"),98);
        
        //这是因为new String时会重新开辟一块内存，所以上面两个String的地址不一相
        //下面是引用的同一个内存地址
        ihm.put("java",93);
        ihm.put("java",98);
        
        System.out.println(ihm);
    }
    
}
