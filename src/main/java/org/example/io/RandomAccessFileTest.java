package org.example.io;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile("RandomAccessFile.txt","r");
            System.out.println("RandomAccessFile的文件指针的初始位置："+raf.getFilePointer());
            //raf.seek(300);
            raf.seek(3);//从哪个位置开始读
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while((hasRead = raf.read(bytes)) > 0){
                System.out.println(new String(bytes,0,hasRead));
            }
        }catch (Exception e){
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
