package org.example.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * synchronized 和 lock 是线程之间协调运行的控制策略
 * 如果要在两条线程之间进行更多的信息交互，则可以考虑使用管道流进行通信
 * 
 * 管道流存在3种形式：
 * PipedInputStream PipedOutputStream
 * PipedRead PipedWriter
 * Pipe.SinkChannel Pipe.SourceChannel
 */
public class PipedCommunicationTest {
    public static void main(String[] args) {
        PipedWriter pw = null;
        PipedReader pr = null;
        try{
            pw = new PipedWriter();
            pr = new PipedReader();
            
            pw.connect(pr);
            new WriterThread(pw).start();
            new ReaderThread(pr).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread{
    private PipedReader pr;
    private BufferedReader br;
    public ReaderThread(){}
    public ReaderThread(PipedReader pr){
        this.pr = pr;
        this.br = new BufferedReader(pr);
    }
    
    public void run(){
        String buf = null;
        try{
            while((buf = br.readLine()) != null){
                System.out.println(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if( br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class WriterThread extends Thread{
    String[] books = new String[]{
            "AAAA",
            "BBB",
            "CCC",
            "DDDD",
            "EEEE"
    };
    
    private PipedWriter pw;
    public WriterThread(){}
    public WriterThread(PipedWriter pw){
        this.pw = pw;
    }
    
    public void run(){
        try{
            for (int i = 0; i < 100; i++) {
                pw.write(books[i%4]+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(pw!=null){
                    pw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
