package ru.geekbrains.jc.hw.fourth;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String msg){
        super("InsufficientFundsException: " + msg);
    }
}
