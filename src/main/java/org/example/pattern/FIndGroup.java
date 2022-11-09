package org.example.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIndGroup {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Java is very easy");
        while(m.find()){
            System.out.println(m.group());
        }
        int i = 0;
        while(m.find(i)){
            System.out.println(m.group()+"\t");
            i++;
        }
    }
}
