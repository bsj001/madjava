package org.example.treeMap;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

enum Season{
    SPRING,SUMMER,FALL,WINTER
}
public class TestEnumMap {
    public static void main(String[] args) {
        EnumMap enumMap = new EnumMap<Season,String>(Season.class);
        enumMap.put(Season.SUMMER,"夏日炎炎");
        enumMap.put(Season.SPRING,"春暖花开");

        System.out.println(enumMap);
        
        for(Object s:enumMap.keySet()){
            System.out.println(enumMap.get(s));
        }

        System.out.println("*****************");

        Iterator it = enumMap.keySet().iterator();
        while(it.hasNext()){
            Object next = it.next();
            System.out.println(enumMap.get(next));
        }
    }
    
}
