package org.example.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) {
        FileChannel fileChannel = null;
        try {
            FileInputStream fis = new FileInputStream("src/main/java/org/example/nio/ReadFile.java");
            fileChannel = fis.getChannel();
            ByteBuffer bbuff = ByteBuffer.allocate(1024);
            while (fileChannel.read(bbuff) != -1) {
                bbuff.flip();
                Charset charset = Charset.forName("gb2312");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer cbuff = decoder.decode(bbuff);
                System.out.println(cbuff);
                bbuff.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null){
                    fileChannel.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
