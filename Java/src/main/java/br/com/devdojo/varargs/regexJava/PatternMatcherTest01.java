package br.com.devdojo.varargs.regexJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        //renan.sereia@gmaill.com
        String regex = "aba";
        String texto = "asdasabaasda";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  "+texto);
        System.out.println("Indice: 0123456789");
        System.out.println("regex:  "+regex);
        System.out.println("texto:  "+texto);
        while (matcher.find()){
            System.out.println(matcher.start()+" ");
        }

    }
}
