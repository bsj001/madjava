package org.example.iterator;
import java.util.HashSet;
import java.util.Iterator;

public class TestIteratorError {
    public static void main(String[] args) {
        //创建一个集合
        HashSet<String> books = new HashSet<String>();
        books.add("A");
        books.add("B");
        //使用iterator
        Iterator it = books.iterator();
        while(it.hasNext()){
            String book = (String) it.next();
            System.out.println(book);
            if(book.equals("A")){
                //books.remove(book);
                it.remove();
            }
        }
        System.out.println(books);

    }
}
