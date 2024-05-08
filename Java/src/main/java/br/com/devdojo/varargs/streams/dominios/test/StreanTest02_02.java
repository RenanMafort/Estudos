package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Orde por titulo em seguida
public class StreanTest02_02 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90),
            new LighNovel("Abcat",2.00),
            new LighNovel("Bol",2.11),
            new LighNovel("Josa",11.90)));

    public static void main(String[] args) {
//        System.out.println(list);

        list.stream().sorted(Comparator.comparing(LighNovel::getTitle)).filter(ln -> ln.getPrice() < 4)
                .limit(3).map(LighNovel::getTitle).collect(Collectors.toSet())
                .forEach(System.out::println);

        list.stream().map(LighNovel::getCategory).forEach(System.out::println);
    }
}
