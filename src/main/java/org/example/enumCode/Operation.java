package org.example.enumCode;

import org.junit.Test;

public enum Operation {
    PLUS,MINUS,TIMES,DIVIDE;
    public double eval(double x,double y){
        switch(this){
            case PLUS:return x+y;
            case MINUS:return x-y;
            case TIMES:return x*y;
            case DIVIDE:return x/y;
            default:return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(PLUS.eval(3,4));
        System.out.println(MINUS.eval(5,4));
        System.out.println(TIMES.eval(5,4));
        System.out.println(DIVIDE.eval(5,4));
    }
}
