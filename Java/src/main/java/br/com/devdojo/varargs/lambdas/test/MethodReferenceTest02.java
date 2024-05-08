package br.com.devdojo.varargs.lambdas.test;

import br.com.devdojo.varargs.lambdas.dominio.Anime;
import br.com.devdojo.varargs.lambdas.dominio.services.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("teste", 2),
                new Anime("testando", 6),
                new Anime("n sei", 500)));

        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

    }
}
