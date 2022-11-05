package org.example;

import org.example.enumCode.Operation;
import org.example.enumCode.Operation2;
import org.junit.Test;

public class OperationTest {
    @Test
    public void testOperation(){
        System.out.println(Operation.PLUS.eval(3,4));
        System.out.println(Operation.MINUS.eval(5,4));
        System.out.println(Operation.TIMES.eval(5,4));
        System.out.println(Operation.DIVIDE.eval(5,4));
    }
    @Test
    public void testOperation2(){
        System.out.println(Operation2.PLUS.eval(3,4));
        System.out.println(Operation2.MINUS.eval(5,4));
        System.out.println(Operation2.TIMES.eval(5,4));
        System.out.println(Operation2.DIVIDE.eval(5,4));
    }
    
    
}
