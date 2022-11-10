package org.example.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class MultiDown {
    public static void main(String[] args) {
        
    }
}

class DownThread extends Thread{
    private final int BUFF_LEN = 32;
    private long start;
    private long end;
    private InputStream is;
    private RandomAccessFile raf;
    
    public DownThread(long start,long end,InputStream is,RandomAccessFile raf){
        System.out.println(start + "----->" + end);
        this.start = start;
        this.end = end;
        this.is = is;
        this.raf = raf;
    }
    public void run(){
        try{
            is.skip(start);
            raf.seek(start);
            byte[] buff = new byte[BUFF_LEN];
            long contentLen = end - start;
            long times = contentLen / BUFF_LEN + 4;
            int hasRead = 0;
            for (int i = 0; i < times; i++) {
                hasRead = is.read(buff);
                if(hasRead < 0){
                    break;
                }
                raf.write(buff,0,hasRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(is != null){
                    is.close();
                }
                if(raf != null){
                    raf.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
