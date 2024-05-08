package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;
import br.com.devdojo.varargs.streams.dominios.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90, Category.DRAMA),
            new LighNovel("Abcat",2.00, Category.FANTASY),
            new LighNovel("Abcat",2.00, Category.ROMANCE),
            new LighNovel("Bol",2.11, Category.DRAMA),
            new LighNovel("Josa",11.90, Category.ROMANCE)));

    public static void main(String[] args) {
        Map<Category, Long> collect = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.counting()));
        System.out.println(collect);
        Map<Category, Optional<LighNovel>> collect1 = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.maxBy(Comparator.comparing(LighNovel::getPrice))));
        System.out.println(collect1);

        Map<Category, LighNovel> collect2 = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LighNovel::getPrice)), Optional::get)));
//        list.stream().collect(Collectors.toMap(LighNovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(LighNovel::getPrice))));
    }
}
