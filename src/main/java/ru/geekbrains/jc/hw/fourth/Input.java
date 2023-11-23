package ru.geekbrains.jc.hw.fourth;

import java.util.Scanner;

public class Input {
    public static String inputString(String msg){
        System.out.print(msg);
        Scanner input = new Scanner(System.in);
        String inputString = input.next();
        return inputString;
    }
    public static Double inputDouble(String msg){
        System.out.print(msg);
        Scanner input = new Scanner(System.in);
        double inputDouble = input.nextDouble();
        return inputDouble;
    }
}
