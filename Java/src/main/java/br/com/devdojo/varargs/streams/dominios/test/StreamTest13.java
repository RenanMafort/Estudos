package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;
import br.com.devdojo.varargs.streams.dominios.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90, Category.DRAMA),
            new LighNovel("Abcat",2.00, Category.FANTASY),
            new LighNovel("Abcat",2.00, Category.ROMANCE),
            new LighNovel("Bol",2.11, Category.DRAMA),
            new LighNovel("Josa",11.90, Category.ROMANCE)));

    public static void main(String[] args) {
        Map<Promotion, List<LighNovel>> collect = list.stream().collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));

        System.out.println(collect);

        //Map<Category,Map<Promotion,Lst<LightNovel>>>
        Map<Category, Map<Promotion, List<LighNovel>>> collect1 = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.groupingBy(lighNovel -> lighNovel.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));

        System.out.println(collect1);
    }
}
