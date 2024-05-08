package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Orde por titulo em seguida
public class StreanTest08 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan", 33.90),
            new LighNovel("Abcat", 26.00),
            new LighNovel("Abcat", 2.00),
            new LighNovel("Bol", 2.11),
            new LighNovel("Josa", 11.90)));
    public static void main(String[] args) {


        list.stream()
                .map(LighNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        List<String> a = list.stream().map(ln -> ln.getTitle()).filter(p -> p.startsWith("A")).collect(Collectors.toList());
        System.out.println(a);
    }

}

