package br.com.devdojo.varargs.streams.dominios.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Orde por titulo em seguida
public class StreanTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Renan", "Caio", "Hon");
        String[] split = words.get(0).split("");
//        System.out.println(Arrays.toString(split));

        List<String[]> collect = words.stream().map(l -> l.split("")).toList();
        for (String[] strings : collect) {
//            System.out.println(Arrays.toString(strings));
        }
//        System.out.println();
//
//         words.stream().
//                map(w -> w.split("")) //Stream<String[]>
//                .flatMap(l -> Arrays.stream(l)
//                        .map(w -> Arrays.stream(w.split(""))
//                        .collect(Collectors.toList())))
//                 .toList().forEach(System.out::print);
////
//        List<List<String>> collect = words.stream().map(w -> w.split("")).flatMap(l -> Arrays.stream(l).map(w -> Arrays.stream(w.split("")).collect(Collectors.toList()))).collect(Collectors.toList());
//        System.out.println(collect);

        words.stream().map(w -> w.split("")).forEach(System.out::println);

    }
}
