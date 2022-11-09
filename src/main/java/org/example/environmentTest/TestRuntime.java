package org.example.environmentTest;

import org.junit.Test;

import java.io.IOException;

/**
 * 提供的是访问JVM相关信息的方法
 */
public class TestRuntime {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量:"+rt.availableProcessors());
        System.out.println("空闲内存数:"+rt.freeMemory());
        System.out.println("总内容数:"+rt.totalMemory());
        System.out.println("可用最大内存数:"+rt.maxMemory());
    }
    @Test
    public void testRun(){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
