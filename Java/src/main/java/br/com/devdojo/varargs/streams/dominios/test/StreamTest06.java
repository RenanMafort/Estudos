package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Orde por titulo em seguida
public class StreamTest06 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan", 33.90),
            new LighNovel("Abcat", 26.00),
            new LighNovel("Abcat", 2.00),
            new LighNovel("Bol", 2.11),
            new LighNovel("Josa", -22.00)));

    List<Integer> test = new ArrayList<>();

    public static void main(String[] args) {
//        boolean b = list.stream().anyMatch(ln -> ln.getPrice() >= 33.90);
//        System.out.println(b);
        System.out.println(list.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(list.stream().noneMatch(ln -> ln.getPrice() > 0));
        System.out.println(list.stream().noneMatch(ln -> ln.getPrice() < 0));
//
        list.stream().filter(ln -> ln.getPrice() > 15).min(Comparator.comparing(LighNovel::getTitle)).ifPresent(System.out::println);
//        list.stream().filter(ln -> ln.getPrice() > 15).min(Comparator.comparing(LighNovel::getTitle)).ifPresent(list::add);
//
//        list.forEach(System.out::println);



    }
}
