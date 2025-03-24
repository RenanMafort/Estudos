package br.com.devdojo.varargs.streams.dominios.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Orde por titulo em seguida
public class StreanTest04 {
    public static void main(String[] args) {
        List<List<String>> escola = new ArrayList<>();
        List<String> graphicDesigners = List.of("Renan Sereia","Caio Gugu","Catarina Hon");
        List<String> developers = List.of("Renan ","Caio","Hon");
        List<String> students = List.of("Jao ","Pepe","Pedro Sants","AHTANGELO");
        escola.add(graphicDesigners);
        escola.add(developers);
        escola.add(students);

        for (List<String> people : escola) {
//                System.out.println(people);
            for (String person : people) {
//                System.out.println(person);
            }
        }

        System.out.println("----------");
        escola.stream().flatMap(Collection::stream).forEach(System.out::println);

    }
}
