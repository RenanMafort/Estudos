package br.com.devdojo.varargs.regexJava.regex.trainee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchTest01 {

    public static void main(String[] args) {
        String regex = "ab";
        String texto = "abaaba";
        String texto2 = "abababa";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);

        System.out.println(texto2);
        System.out.println("0123456789");

        while (matcher.find()){
            System.out.print(matcher.start() + " "+matcher.group() + "\n");
        }


    }

}
