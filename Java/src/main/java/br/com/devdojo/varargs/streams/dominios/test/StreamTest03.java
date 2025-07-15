package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Orde por titulo em seguida
public class StreamTest03 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90),
            new LighNovel("Abcat",2.00),
            new LighNovel("Abcat",2.00),
            new LighNovel("Bol",2.11),
            new LighNovel("Josa",11.90)));

    public static void main(String[] args) {


        Stream<LighNovel> stream = list.stream();
        list.forEach(System.out::println);//With this is best
        list.forEach(System.out::println);

        long count = stream.filter(lighNovel -> lighNovel.getPrice() <=4).count();
        long count2 =list.stream().filter(lighNovel -> lighNovel.getPrice() <=4).distinct().count();// apos utilizat o stream devemos fazer a chamada novamente
        System.out.println(count);
        System.out.println(count2);

    }
}
