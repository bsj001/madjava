package org.example.network.multiThread;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    
    Socket s = null;
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try{
            String content = null;
            while((content = readFromClient())!=null){
                for(Socket s : MyServer.socketList){
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String readFromClient() {
        try{
            return br.readLine();
        }catch (IOException e){
            MyServer.socketList.remove(s);
        }
        return null;
    }


}
