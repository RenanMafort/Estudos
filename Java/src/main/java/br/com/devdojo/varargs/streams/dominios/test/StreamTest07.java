package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.lambdas.dominio.Anime;

import java.util.List;

//Orde por titulo em seguida
public class StreamTest07 {
    public static void main(String[] args) {
        Anime anime = new Anime("Renan",2);
        Anime anime2 = new Anime("Sereia",3);


         List<Integer> list = List.of(1,2,3,4,6,7,8,9);
         list.stream().reduce((x,y) -> x + y).ifPresent(System.out::println);
         list.stream().reduce(Integer::sum).ifPresent(System.out::println);
        Integer reduce = list.stream().reduce(10, Integer::sum);
        System.out.println(reduce);

        list.stream().reduce((a,b) -> a > b ? a : b).ifPresent(System.out::println);
        list.stream().reduce((a,b) -> a < b ? a : b).ifPresent(System.out::println);
        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        list.stream().reduce(Integer::min).ifPresent(System.out::println);
        Integer reduce1 = list.stream().reduce(9, Integer::max);
        System.out.println(list.stream().reduce(9,Integer::max));
        list.stream().reduce(Integer::min).ifPresent(System.out::println);

    }

}

