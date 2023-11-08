package ru.geekbrains.jc.hw.first;
/**
 * Class removes in String all punctuation, then replaces all spaces into underline
 * If the last char of the text is underline this Class removes it.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnderlineSpaces {
    public static String underlineSpaces (String text){
        Pattern pattern = Pattern.compile("\\p{P}");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("");
        text = text.replaceAll("(\\s)", "_"); // RegEx \\s определяет пробел в строке
        if (text.charAt(text.length()-1) == '_'){
            return text.substring(0, text.length()-1);
        }
        return text;
    }
}
