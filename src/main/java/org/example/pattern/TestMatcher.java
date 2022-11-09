package org.example.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMatcher {
    public static void main(String[] args) {
        String[] mails = {
                "adsgdf@163.com",
                "b@163.com",
                "csfgsf@163.com",
                "d@163.com"
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for(String mail:mails){
            if(matcher == null){
                matcher = mailPattern.matcher(mail);
            }else {
                matcher.reset(mail);
            }
            if(matcher.matches()){
                System.out.println(mail+"是一个有效的邮件地址！");
            }else{
                System.out.println(mail+"不是一个有效的邮件地址");
            }
        }
    }
}
