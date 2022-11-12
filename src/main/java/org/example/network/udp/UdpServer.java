package org.example.network.udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.channels.DatagramChannel;

public class UdpServer {
    public static final int PORT = 30000;
    private static final int DATA_LEN = 4096;
    private DatagramSocket socket = null;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
    
    private DatagramPacket outPacket;
    
    String[] books = new String[]{
            "轻量级J2EE企业应用实战",
            "基于J2EE的Ajax宝典",
            "Structs2权威指南",
            "ROP敏捷开发最佳实践"
    };
    
    public void init() throws IOException{
        try{
            socket = new DatagramSocket(PORT);
            for(int i=0;i<1000;i++){
                socket.receive(inPacket);
                System.out.println(inBuff == inPacket.getData());
                System.out.println(new String(inBuff,0,inPacket.getLength()));
                byte[] sendData = books[i%4].getBytes();
                outPacket = new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
                socket.send(
                        outPacket);
            }
        }finally {
            if(socket != null){
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new UdpServer().init();
    }
    
}
