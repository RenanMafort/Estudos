package br.com.devdojo.varargs.regexJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d = Todos os numeros
        // \D = Tudo o que não for número
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo o branco
        // \w = a-ZA-Z, numeros, e _
        // \W = Tudo o que não for  a-ZA-Z, numeros, e _
        String regex = "\\W";
        String texto = "as#@S_WWASDda 2\tsa\s2b\fa4asdSa";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  "+texto);
        System.out.println("Indice: 0123456789");
        System.out.println("regex:  "+regex);

        while (matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group()+" ");
        }

    }
}
