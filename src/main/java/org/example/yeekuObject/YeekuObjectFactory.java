package org.example.yeekuObject;

public class YeekuObjectFactory {
    public static Object getInstance(String clsName){
        try{
            Class cls = Class.forName(clsName);
            return cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
