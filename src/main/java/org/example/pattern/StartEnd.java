package org.example.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
    public static void main(String[] args) {
        String regStr = "Java is very easy!";
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while(m.find()){
            System.out.println(m.group()+"子串的起始位置"+m.start()+"，其结束位置:"+m.end());
        }
    }
}
