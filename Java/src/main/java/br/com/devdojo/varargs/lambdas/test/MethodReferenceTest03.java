package br.com.devdojo.varargs.lambdas.test;

import br.com.devdojo.varargs.lambdas.dominio.Anime;
import br.com.devdojo.varargs.lambdas.dominio.services.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Abacate","Bola","JotaJota"));
        names.sort(String::compareTo);
        System.out.println(names);

        Function<String,Integer> parsteInteger = Integer::parseInt;
        Integer num = parsteInteger.apply("10");
//        Integer num = parsteInteger.apply("8");
        System.out.println(num);


        Predicate<List<String>> contains = s -> s.contains("Abacate");
//        boolean test = contains.test(names);
//        System.out.println(test);


        BiPredicate<List<String>,String> checkName = List::contains;
        boolean renan = checkName.test(names, "Renan");
        System.out.println(renan);

        BiFunction<String, Integer, Anime> animes = Anime::new;
        Anime debs = animes.apply("Debs", 20);
        System.out.println(debs);


    }
}
