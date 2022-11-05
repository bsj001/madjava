package org.example.enumCode;

public enum Gender2 {
    MALE("男"),FEMALE("女");

    private String name;

    private Gender2(String name){
        this.name = name;
    }

    
    public String getName(){
        return this.name;
    }
}
