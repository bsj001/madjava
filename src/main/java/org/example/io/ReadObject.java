package org.example.io;

import java.io.*;

public class ReadObject {
    public static void main(String[] args) {
        ObjectInputStream  ois = null;
        
        try{
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Person person = (Person) ois.readObject();
            System.out.println(person.getName()+":"+person.getAge());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
