package br.com.devdojo.varargs.regexJava;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
        // \d = Todos os numeros
        // \D = Tudo o que não for número
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo o branco
        // \w = a-ZA-Z, numeros, e _
        // \W = Tudo o que não for  a-ZA-Z, numeros, e _
        //[]
        //? Zero ou uma ocorrencia
        //* zero ou mais
        //+ uma ou mais
        //{n,m} de n até m
        //() agrupamento
        // | o(v|c) ovo | oco
        //$ fim da linha
        //. 1.3 = 123 OU 133 OU 1@3
//        String regex = "[a-zA-C]";
        String regex = "([a-zA-Z0-9\\._-])+@([A-Za-z])+(\\.([A-Za-z])+)+";
        String regex2 = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+\\.+";
        String texto = "Renan@hotmail.com.br 123.jotar@gmail.com, #$!zoro@mail.br, teste@gmail.com, saura@mail ";
        System.out.println("@!@#$123.jotar@gmail.com".matches(regex));
        System.out.println(Arrays.toString(texto.replace(" ","").split(",")));
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  "+texto);
        System.out.println("Indice: 0123456789");
        System.out.println("regex:  "+regex2);

        while (matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group()+" ");
        }

        int numeroRex = 0x9F864;
        System.out.println(numeroRex);

    }
}
