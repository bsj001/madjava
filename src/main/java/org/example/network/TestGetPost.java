package org.example.network;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 测试 GET 和 POST 请求
 */
public class TestGetPost {
    /**
     * 向指定URL发送GET方法的请求
     * @param url 发送请求URL
     * @param param 发送请求URL的参数
     */
    public static String sendGet(String url,String param){
        String result = "";
        BufferedReader in = null;
        try{
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求发展
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
            //建立实际的连接
            conn.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String key: map.keySet()){
                System.out.println(key + "--->"+map.get(key));
            }
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine())!=null){
                result += "\n" + line;
            }
        }catch (Exception e){
            System.out.println("发送GET请求出现异常"+e);
            e.printStackTrace();
        }finally {
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public static String sendPost(String url,String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try{
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.println(param);
            //flush输出流的缓冲
            out.flush();
            
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine())!= null){
                result += "\n" + line;
            }
        }catch (Exception e){
            System.out.println("发送POST请求出现异常"+e);
            e.printStackTrace();
        }finally {
            try{
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String s = TestGetPost.sendGet("http://localhost/reqeust/", null);
        System.out.println(s);
        String s1 = TestGetPost.sendPost("http://localhost/reqeust/", "user=root&pass=root");
        System.out.println(s1);
    }
    
    
}
