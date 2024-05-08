package br.com.devdojo.varargs.regexJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // \d = Todos os numeros
        // \D = Tudo o que não for número
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo o branco
        // \w = a-ZA-Z, numeros, e _
        // \W = Tudo o que não for  a-ZA-Z, numeros, e _
        //[]
//        String regex = "[a-zA-C]";
        String regex = "0[Xx][0-9a-fA-F]";
        String texto = "12 0x 0x 0xFFABC 0x109 0x1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  "+texto);
        System.out.println("Indice: 0123456789");
        System.out.println("regex:  "+regex);

        while (matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group()+" ");
        }

        int numeroRex = 0x9F864;
        System.out.println(numeroRex);

    }
}
