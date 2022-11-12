package org.example.network.yeek;

import org.junit.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;
    public void init(){
        try{
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket("127.0.0.1",SERVER_PORT);
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            while(true){
                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                ps.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);
                String result = brServer.readLine();
                if(result.equals(YeekuProtocol.NAME_REP)){
                    tip = "用户名重复，请重新";
                    continue;
                }
                if(result.equals(YeekuProtocol.LOGIN_SUCCESS)){
                    break;
                }
            }
        }catch (UnknownHostException e){
            System.out.println("找不到远程服务器，请确定服务器已经启动");
            closeRs();
            System.exit(1);
        }catch (IOException e){
            System.out.println("网络异常！请重新登录");
            closeRs();
            System.exit(1);
        }
        new ClientThread(brServer).start();
    }
    private void readAndSend(){
        try{
            String line = null;
            while((line = keyIn.readLine()) != null){
                //私聊格式: //aa:hello
                //转换后的格式：PRIVATE_ROUND + aa + SPLIT_SIGN + hello + PRIVATE_ROUND
                if(line.indexOf(":") > 0 && line.startsWith("//")){
                    line = line.substring(2);
                    ps.println(YeekuProtocol.PRIVATE_ROUND + 
                            line.split(":")[0]+YeekuProtocol.SPLIT_SIGN+
                            line.split(":")[1] + YeekuProtocol.PRIVATE_ROUND);
                }else{
                    //公开聊格式: hello
                    //转换后的格式：MSG_ROUND + hello + MSG_ROUND
                    ps.println(YeekuProtocol.MSG_ROUND + line + YeekuProtocol.MSG_ROUND);
                }
            }
        }catch (IOException e){
            System.out.println("网络异常，请重新登录");
            closeRs();
            System.exit(1);
        }
    }
    private void closeRs(){
        try{
            if(keyIn != null){
                ps.close();
            }
            if(brServer != null){
                ps.close();
            }
            if(ps != null){
                ps.close();
            }
            if(socket != null){
                keyIn.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.readAndSend();
    }
}
