package org.example;

import org.example.enumCode.Gender;
import org.junit.Test;

public class GenderTest {
    @Test
    public void testGender1(){
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        g.setName("女");
        System.out.println(g+"代表:"+g.getName());
        //此时设置name属性时将会提示参数错误
        g.setName("男");
        System.out.println(g+"代表:"+g.getName());
    }
}
