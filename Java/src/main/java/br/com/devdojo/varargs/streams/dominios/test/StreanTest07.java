package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

//Orde por titulo em seguida
public class StreanTest07 {
    public static void main(String[] args) {
         List<Integer> list = List.of(1,2,3,4,6,7,8,9);
         list.stream().reduce((x,y) -> x + y).ifPresent(System.out::println);
         list.stream().reduce(Integer::sum).ifPresent(System.out::println);
        Integer reduce = list.stream().reduce(10, Integer::sum);
        System.out.println(reduce);

        list.stream().reduce((a,b) -> a > b ? a : b).ifPresent(System.out::println);
        list.stream().reduce((a,b) -> a < b ? a : b).ifPresent(System.out::println);
        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        System.out.println(list.stream().reduce(20,Integer::max));
        list.stream().reduce(Integer::min).ifPresent(System.out::println);

    }

}

