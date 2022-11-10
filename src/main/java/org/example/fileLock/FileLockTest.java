package org.example.fileLock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) {
        FileChannel channel = null;
        try{
            channel = new FileOutputStream("a.txt").getChannel();
            FileLock lock = channel.tryLock();
            Thread.sleep(5000);
            lock.release();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(channel != null){
                    channel.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
