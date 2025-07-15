package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class    StreamTest11 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90),
            new LighNovel("Abcat",2.00),
            new LighNovel("Abcat",2.00),
            new LighNovel("Bol",2.11),
            new LighNovel("Josa",11.90)));

    public static void main(String[] args) {
        System.out.println(list.stream().count());
        System.out.println(list.stream().collect(Collectors.counting()));

        list.stream().max(Comparator.comparing(LighNovel::getPrice)).ifPresent(System.out::println);
        list.stream().collect(Collectors.maxBy(Comparator.comparing(LighNovel::getPrice))).ifPresent(System.out::println);

        double sum = list.stream().mapToDouble(LighNovel::getPrice).sum();
        System.out.println(sum);

        Double collect = list.stream().mapToDouble(LighNovel::getPrice).sum();
        System.out.println(collect);

        DoubleSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingDouble(LighNovel::getPrice));
        System.out.println(collect1);

        //Pega as estatisticas da lista -> DoubleSummaryStatistics{count=5, sum=51,910000, min=2,000000, average=10,382000, max=33,900000}
        DoubleSummaryStatistics collect2 = list.stream().collect(Collectors.summarizingDouble(LighNovel::getPrice));
        System.out.println(collect2);

        String collect3 = list.stream().map(LighNovel::getTitle).collect(Collectors.joining(", "));
        System.out.println(collect3);

    }
}
