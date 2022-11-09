package org.example.collectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Collections提供了如下几个方法用于对List集合进行排序
 * static void reverse(List list) ：反转
 * static void shuffle(List list) : 随机排序
 * static void sort(List list): 自然排序
 * static void sort(List list,Comparator c):指定排序
 * static void swap(List list,int i,int j):将指定List集合中i处元素和j处元素进行交换
 * static void rotate(List list,int distance):把list.size()-1-i中处之后的元素全部插入前面
 */
public class TestSort {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-24);
        list.add(235425);
        list.add(4654);
        list.add(2423);

        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
        
        //Collections.sort(list);
        //System.out.println(list);
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2;//升
                return o2-o1;//降
            }
        });
        System.out.println(list);

        Collections.swap(list,0,list.size()-1);
        System.out.println(list);//[-24, 4654, 2423, 3, 235425]
        
        Collections.rotate(list,2); //[3, 235425, -24, 4654, 2423]
        System.out.println(list);

    }
}
