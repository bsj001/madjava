package org.example.treeMap;

import java.util.TreeMap;

class R implements Comparable{
    int count;
    public R(int count){
        this.count = count;
    }
    
    public String toString(){
        return "R(count属性:"+count+")";
    }
    
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj != null
            && obj.getClass() == R.class){
            R r = (R) obj;
            if(r.count == this.count){
                return true;
            }
        }
        return false;
    }
    
    public int compareTo(Object obj){
        R r = (R) obj;
        if(this.count > r.count){
            return 1;
        }else if(this.count == r.count){
            return 0;
        }else {
            return -1;
        }
    }
}

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new R(3),"AAA");
        tm.put(new R(-5),"BBB");
        tm.put(new R(8),"CCC");

        System.out.println(tm);
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastKey());
        System.out.println("*************************");
        System.out.println(tm.higherEntry(new R(2)));
        System.out.println(tm.lowerEntry(new R(2)));
        System.out.println(tm.subMap(new R(-1),new R(4)));
    }
}