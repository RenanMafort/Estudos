package br.com.devdojo.varargs.regexJava.regex.trainee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchTest02 {

    public static void main(String[] args) {
        // \d - Todos os digitos
        // \D - Tudo que não for digito
        // \s - Espaços em branco \t \n \f \t
        String regex = "[a-cA-C]";
        String texto = "abac123akklABChjkh144ba";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println(texto);
        System.out.println("0123456789");

        while (matcher.find()){
            System.out.print(matcher.start() + " "+matcher.group() + "\n");
        }

        int hexdecial = 0x59F86A;
        System.out.println(hexdecial);


    }

}
