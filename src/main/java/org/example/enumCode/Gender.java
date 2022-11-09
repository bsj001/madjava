package org.example.enumCode;

import org.junit.Test;

public enum Gender {
    MALE,FEMALE;
    private String name;
    public void setName(String name){
        switch(this){
            case MALE:
                if(name.equals("男")){
                    this.name = name;
                }else{
                    System.out.println("参数错误");
                    break;
                }
            case FEMALE:
                if(name.equals("女")){
                    this.name = name;
                }else{
                    System.out.println("参数错误");
                    break;
                }
        }
    }
    
    public String getName(){
        return this.name;
    }


    public static void main(String[] args) {
        Gender g = valueOf(Gender.class, "FEMALE");
        g.setName("女");
        System.out.println(g+"代表:"+g.getName());
        //此时设置name属性时将会提示参数错误
        g.setName("男");
        System.out.println(g+"代表:"+g.getName());
    }
}
