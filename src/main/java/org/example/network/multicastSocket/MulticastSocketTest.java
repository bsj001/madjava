package org.example.network.multicastSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * 使用MulticastSocket实现多点广播
 */
public class MulticastSocketTest implements Runnable {
    private static final String BROADCAST_IP = "230.0.0.1";
    public static final int BROADCAST_PORT = 30000;
    private static final int DATA_LEN = 4096;
    
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scanner = null;
    byte[] inBuff = new byte[DATA_LEN];
    
    private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
    private DatagramPacket outPacket = null;
    
    public void init() throws IOException {
        try{
            socket = new MulticastSocket(BROADCAST_PORT);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            socket.joinGroup(broadcastAddress);
            //将该socket加入指定的多点广播地址
            socket.setLoopbackMode(false);
            outPacket = new DatagramPacket(new byte[0],0,broadcastAddress,BROADCAST_PORT);
            new Thread(this).start();
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                byte[] buff = scanner.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
            }
        }finally {
            socket.close();
        }
    }
    
    @Override
    public void run(){
        try{
            while (true){
                socket.receive(inPacket);
                System.out.println("聊天信息："+new String(inBuff,0,inPacket.getLength()));
            }
        }catch (IOException e){
            e.printStackTrace();
            try{
                if(socket != null){
                    socket.leaveGroup(broadcastAddress);
                    socket.close();
                }
                System.exit(1);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new MulticastSocketTest().init();
    }
    
}
