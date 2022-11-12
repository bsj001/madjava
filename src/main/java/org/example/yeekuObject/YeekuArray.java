package org.example.yeekuObject;

import java.lang.reflect.Array;

public class YeekuArray {
    public static <T> T[] newInstance(Class<T> componentType,int length){
        return (T[])Array.newInstance(componentType,length);
    }

    public static void main(String[] args) throws Exception {
        String[] arr = YeekuArray.newInstance(String.class,10);
        int[][] intArr = YeekuArray.newInstance(int[].class,5);
        arr[5] = "asfidsjfowsjfiwe";
        intArr[1] = new int[]{23,12};
        System.out.println(arr[5]);
        System.out.println(intArr[1][1]);
    }
}
