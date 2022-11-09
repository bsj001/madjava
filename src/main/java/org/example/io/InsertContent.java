package org.example.io;

import java.io.*;

public class InsertContent {
    public static void main(String[] args) {
        try {
            insert("InsertContent.txt",49,"插入的内容\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static void insert(String fileName,long pos,String insertContent) throws IOException{
        RandomAccessFile raf = null;
        File tmp = File.createTempFile("tmp",null);
        FileOutputStream tmpOut = null;
        FileInputStream tmpIn = null;
        tmp.deleteOnExit();

        try{
            raf = new RandomAccessFile(fileName,"rw");
            tmpOut = new FileOutputStream(tmp);
            tmpIn = new FileInputStream(tmp);
            
            if(pos >= raf.length()){
                pos = 0;
            }
            raf.seek(pos);
            byte[] bbuf = new byte[64];
            int hasRead = 0;
            while((hasRead = raf.read(bbuf))>0){
                tmpOut.write(bbuf,0,hasRead);
            }
            
            raf.seek(pos);
            raf.write(insertContent.getBytes());
            while((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write(bbuf,0,hasRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            raf.close();
        }
    }
}
