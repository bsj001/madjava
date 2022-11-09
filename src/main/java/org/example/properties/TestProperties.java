package org.example.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("username","root");
        props.setProperty("password","123456");

        try {
            props.store(new FileOutputStream("a.ini"),"comment line");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Properties props2 = new Properties();
        
        props2.setProperty("gender","male");
        try {
            props2.load(new FileInputStream("a.ini"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(props2);
    }
}
