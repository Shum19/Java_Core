package ru.geekbrains.jc.hw.first;

public class MainApp {
    public static void main(String [] args){
        String test = Input.inputString();
        do {
            test = UnderlineSpaces.underlineSpaces(test);
            System.out.println(test);
            test = UnderlineSpaces.underlineSpaces(test);
        }while (test =="exit");
    }
}
