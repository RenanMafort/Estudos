package br.com.devdojo.varargs.lambdas.test;

import br.com.devdojo.varargs.lambdas.dominio.Anime;
import br.com.devdojo.varargs.lambdas.dominio.services.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> animeComparatorsSupplier = AnimeComparators::new;
        Supplier<AnimeComparators> animeComparatorsSupplier2 = () -> new AnimeComparators();
        AnimeComparators animeComparators1 = animeComparatorsSupplier2.get();

        AnimeComparators animeComparators = animeComparatorsSupplier.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("teste", 2),
                new Anime("testando", 6),
                new Anime("n sei", 500)));

        animeList.sort(AnimeComparators::compareByEpisodes);
        System.out.println(animeList);

//        BiFunction<String, Integer,Anime> animeBiFunction = (t,e ) -> new Anime(t,e);
        BiFunction<String, Integer,Anime> animeBiFunction = Anime::new;
        Anime renan = animeBiFunction.apply("Renan", 2);
        System.out.println(renan);

    }
}
