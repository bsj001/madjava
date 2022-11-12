package org.example.network.yeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    
    public void run(){
        try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while((line = br.readLine()) != null){
                //如果读到的行以USER_ROUND开始，并以其结束，
                //可以确定读到的是用户登录的用户名
                if(line.startsWith(YeekuProtocol.USER_ROUND) &&
                        line.endsWith(YeekuProtocol.USER_ROUND)){
                    String username = getRealMsg(line);
                    if(Server.clients.containsKey(username)){
                        System.out.println("重复");
                        ps.println(YeekuProtocol.NAME_REP);
                    }else{
                        System.out.println("成功");
                        ps.println(YeekuProtocol.LOGIN_SUCCESS);
                        Server.clients.put(username,ps);
                    }
                //如果读的行是以PRIVATE_ROUND开始，并以其结束 
                //可以确定是私聊信息，私聊信息中向特定的输出流发送    
                }else if(line.startsWith(YeekuProtocol.PRIVATE_ROUND) &&
                line.endsWith(YeekuProtocol.PRIVATE_ROUND)){
                    String userAndMsg = getRealMsg(line);
                    String user = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[0];
                    String msg = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[1];
                    Server.clients.get(user).println(
                            Server.clients.getKeyByValue(ps)+"悄悄地对你说:"+ msg
                    );
                }else {
                    //公开聊天信息
                    String msg = getRealMsg(line);
                    for(PrintStream clientPs :Server.clients.valueSet()){
                        clientPs.println(Server.clients.getKeyByValue(ps)+"说："+msg);
                    }
                }
            }
        }catch (IOException e){
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.size());
            //e.printStackTrace();
            try{
                if(br != null){
                    br.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public String getRealMsg(String line){
        return line.substring(YeekuProtocol.PROTOCOL_LEN,
                line.length() - YeekuProtocol.PROTOCOL_LEN);
    }
}
