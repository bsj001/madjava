package org.example.yeekuObject;

import javax.swing.*;
import java.util.Date;

public class YeekuObjectFactory2 {
    public static<T> T getInstance(Class<T> cls){
        try{
            return cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Date d = YeekuObjectFactory2.getInstance(Date.class);
        JFrame f = YeekuObjectFactory2.getInstance(JFrame.class);
    }
}
