package ru.geekbrains.jc.hw.first;

import java.util.Scanner;

/**
 * Class takes data types as String, Integer, Float and other inserting them into console line and returns them
 */
public class Input {

    public static String inputString() {
        System.out.println("Enter the text");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        if(text == ""){
            System.out.println("Text is Empty. Try Again");
            text = inputString();
        }
        return text;
    }


    public static int inputInteger() {
        return 0;
    }
}
