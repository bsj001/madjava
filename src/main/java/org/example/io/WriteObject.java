package org.example.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        
        try{
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Person per = new Person("孙悟空", 500,"美猴王");
            oos.writeObject(per);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
