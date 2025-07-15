package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Orde por titulo em seguida
public class StreamTest02 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90, Category.DRAMA),
            new LighNovel("Abcat",5.00,Category.FANTASY),
            new LighNovel("Bol",2.11,Category.FANTASY),
            new LighNovel("Josa",11.90)));

    public static void main(String[] args) {
//        System.out.println(list);

        ArrayList<LighNovel> lighNovels = new ArrayList<>();

        list.stream().sorted(Comparator.comparing(LighNovel::getTitle))
                .filter(p -> p.getPrice() >= 4).limit(3).map(LighNovel::getCategory).forEach(System.out::println);

        list.stream().sorted(Comparator.comparing(LighNovel::getTitle))
                .filter(p -> p.getPrice() >= 4).limit(3).forEach(lighNovels::add);


    }
}
