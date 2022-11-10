package org.example.network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String keyword = URLDecoder.decode("%E6%9D%8E%E5%88%9A+j2ee", "UTF-8");
        System.out.println(keyword);

        String urlStr = URLEncoder.encode("李刚", "GBK");
        //String urlStr = URLEncoder.encode("李刚 j2ee", "UTF-8");
        System.out.println(urlStr);
    }
}
