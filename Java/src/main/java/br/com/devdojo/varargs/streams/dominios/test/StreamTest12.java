package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest12 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90, Category.DRAMA),
            new LighNovel("Abcat",2.00, Category.FANTASY),
            new LighNovel("Abcat",2.00, Category.ROMANCE),
            new LighNovel("Bol",2.11, Category.DRAMA),
            new LighNovel("Josa",11.90, Category.ROMANCE)));

    public static void main(String[] args) {
        Map<Category,List<LighNovel>> categoryListMap = new HashMap<>();
        List<LighNovel> fantasy = new ArrayList<>();
        List<LighNovel> drama = new ArrayList<>();
        List<LighNovel> romance = new ArrayList<>();

        for (LighNovel lighNovel : list) {
            switch (lighNovel.getCategory()) {
                case DRAMA -> drama.add(lighNovel);
                case FANTASY -> fantasy.add(lighNovel);
                case ROMANCE -> romance.add(lighNovel);
            }
        }

        categoryListMap.put(Category.ROMANCE,romance);
        categoryListMap.put(Category.FANTASY,fantasy);
        categoryListMap.put(Category.DRAMA,drama);

        System.out.println(categoryListMap);

        System.out.println("-----------");
        Map<Category, List<LighNovel>> collect = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory));
        System.out.println(collect);


    }
}
