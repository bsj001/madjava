package org.example.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
    public static void main(String[] args) {
        FileChannel randomChannel = null;
        try{
            File f = new File("a.txt");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            randomChannel = raf.getChannel();
            MappedByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            randomChannel.position(f.length());
            randomChannel.write(buffer);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(randomChannel != null){
                    randomChannel.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
