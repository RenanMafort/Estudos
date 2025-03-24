package br.com.devdojo.varargs.lambdas.test;

import br.com.devdojo.varargs.lambdas.dominio.Anime;
import br.com.devdojo.varargs.lambdas.dominio.services.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("teste", 2),
                new Anime("testando", 6),
                new Anime("n sei", 500)));


        animeList.sort(AnimeComparators::compareByEpisodes);

        animeList.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        Collections.sort(animeList, Comparator.comparing(Anime::getTitle));
        System.out.println(animeList);
    }
}
