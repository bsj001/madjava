package org.example.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile("out.txt","rw");
            raf.seek(raf.length());
            raf.write("追加的内容!\r\n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(raf!=null){
                    raf.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
