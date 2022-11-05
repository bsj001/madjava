package org.example.enumCode;

public enum Operation2 {
    
    PLUS{
        public double eval(double x,double y){
            return x + y;
        }
    },
    MINUS{
        public double eval(double x,double y){
            return x - y;
        }
    },
    TIMES{
        public double eval(double x,double y){
            return x * y;
        }
    },
    DIVIDE{
        public double eval(double x,double y){
            return x / y;
        }
    };
    
    public abstract double eval(double x,double y);
    
}
