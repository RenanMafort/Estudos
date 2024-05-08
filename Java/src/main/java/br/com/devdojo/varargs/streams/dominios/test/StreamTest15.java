package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;
import br.com.devdojo.varargs.streams.dominios.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {
    private static Promotion getPromotion(LighNovel ln){
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION: Promotion.NORMAL_PRICE;
    }
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90, Category.DRAMA),
            new LighNovel("Abcat",2.00, Category.FANTASY),
            new LighNovel("Abcat",2.00, Category.ROMANCE),
            new LighNovel("Bol",2.11, Category.DRAMA),
            new LighNovel("Josa",11.90, Category.ROMANCE)));

    public static void main(String[] args) {
        Map<Category, DoubleSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.summarizingDouble(LighNovel::getPrice)));
        System.out.println(collect);

        Map<Category, List<Promotion>> collect1 = list.stream().collect(Collectors.groupingBy(LighNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toList())));
        System.out.println(collect1);

    }
}
