package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.LighNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//Orde por titulo em seguida
public class StreanTest01 {
    private static List<LighNovel> list = new ArrayList<>(List.of(
            new LighNovel("Renan",33.90),
            new LighNovel("Abcat",2.00),
            new LighNovel("Bol",2.11),
            new LighNovel("Josa",11.90)));

    public static void main(String[] args) {
        list.sort(Comparator.comparing(LighNovel::getTitle));
        List<String> results = new ArrayList<>();
        System.out.println(list);
        for (LighNovel lighNovel : list) {

            if (lighNovel.getPrice() <=4){
                results.add(lighNovel.getTitle());
            }
            if (results.size() >=3){
                break;
            }
        }

        System.out.println(results);




    }
}
