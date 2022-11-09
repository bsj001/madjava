package org.example.iterator;

import java.util.HashSet;
import java.util.Objects;

public class TestForeach {
    public static void main(String[] args) {
        HashSet<String> books = new HashSet<>();
        books.add("A");
        books.add("B");
        books.add("C");
        books.add("D");
        
        for(String book:books){
            System.out.println(book);
            if(book.equals("A")){
                //会引发异常
                //books.remove(book);
            }
        }
    }
}
