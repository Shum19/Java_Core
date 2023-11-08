package ru.geekbrains.jc.hw.first;

public class MainApp {
    public static void main(String [] args){
        String test = Input.inputString();
        test = UnderlineSpaces.underlineSpaces(test);
        System.out.println(test);
    }
}
