package org.example.wildcardCharacter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 通配符的正限
 */
public class MyUtils {
    public static <T> T copy(Collection<? super T> dest,Collection<T> src){
        T last = null;
        for(T ele : src){
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        ArrayList<Number> ln = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        li.add(5);
        li.add(3);
        li.add(2);
        //此处可准确的知识最后一个被复制的元素是Integer类型(与src集合元素的类型相同）
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
