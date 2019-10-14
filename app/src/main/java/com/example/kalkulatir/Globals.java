package com.example.kalkulatir;

public class Globals{
    private static Globals instance;

    private double leftOperand;
    private double rightOperand;
    private char operation;

    private Globals(){}

    public void setLeftOperand(double d){
        this.leftOperand = d;
    }
    public double getLeftOperand(){
        return this.leftOperand;
    }

    public void setRightOperand(double d){
        this.rightOperand = d;
    }
    public double getRightOperand(){
        return this.rightOperand;
    }

    public void setOperation(char d){
        this.operation = d;
    }
    public char getOperation(){
        return this.operation;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}



