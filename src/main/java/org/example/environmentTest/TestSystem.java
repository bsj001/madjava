package org.example.environmentTest;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class TestSystem {
    public static void main(String[] args) throws IOException {
        Map<String, String> env = System.getenv();
        for(String name:env.keySet()){
            System.out.println(name+"----->"+env.get(name));
        }

        System.out.println("*********************");
        System.out.println(System.getenv("JAVA_HOME"));
        Properties props = System.getProperties();
        props.store(new FileOutputStream("props.txt"),"System Properties");
        System.out.println(System.getProperty("os.name"));
    }

    /**
     * hashcode是通过value来确定的
     * 内存地址identityHashCode
     */
    @Test
    public void test(){
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1.hashCode()+"-------"+s2.hashCode());

        System.out.println(System.identityHashCode(s1)+"-============="+System.identityHashCode(s2));

        String s3 = "JAVA";
        String s4 = "JAVA";
        System.out.println(System.identityHashCode(s3)+"-============="+System.identityHashCode(s4));
    }
    @Test
    public void testTime(){
        long t1 = System.currentTimeMillis();//毫秒级别的时间
        long t2 = System.nanoTime();//微秒级别的时间
    }
}
