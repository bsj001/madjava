package org.example.proxy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

public class ProxySelectorTest {
    public void setLocalProxy(){
        Properties prop = System.getProperties();
        prop.setProperty("http.proxyHost","10.10.0.96");
        prop.setProperty("http.proxyPort","8080");
        prop.setProperty("http.nonProxyHosts","localhost|10.20.*");
        
        prop.setProperty("https.proxyHost","192.168.0.96");
        prop.setProperty("https.proxyPort","443");
        prop.setProperty("ftp.proxyHost","10.10.0.96");
        prop.setProperty("ftp.proxyPort","2121");
        prop.setProperty("ftp.nonProxyHosts","localhost|10.10.*");
        prop.setProperty("socks.proxyHost","10.10.0.96");
        prop.setProperty("socks.proxyPort","1080");
    }
    
    //清除proxy设置
    public void removeLocalProxy(){
        Properties prop = System.getProperties();
        prop.remove("http.proxyHost");
        prop.remove("http.proxyPort");
        prop.remove("http.nonProxyHosts");
        
        prop.remove("https.proxyHost");
        prop.remove("https.proxyPort");
        
        prop.remove("ftp.proxyHost");
        prop.remove("ftp.proxyPort");
        prop.remove("ftp.nonProxyHosts");
        
        prop.remove("socks.proxyHost");
        prop.remove("socks.proxyPort");
    }
    
    public void showHttpProxy() throws MalformedURLException, IOException {
        URL url = new URL("https://www.bilibili.com");
        URLConnection conn = url.openConnection();
        Scanner scanner = new Scanner(conn.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) throws IOException {
        ProxySelectorTest test = new ProxySelectorTest();
        test.setLocalProxy();
        test.showHttpProxy();
        test.removeLocalProxy();
    }
}
