package sereia.renan.springwebflux.util;

import sereia.renan.springwebflux.domain.Anime;

public class AnimeCreator {

    public static Anime animeToBeSaved(){
        return Anime.builder()
                .name("Renan Mafort Sereia")
                .build();
    }

    public static Anime animeValid(){
        return Anime.builder()
                .id(1)
                .name("Renan Mafort Sereia")
                .build();
    }

    public static Anime animeToBeUpdate(){
        return Anime.builder()
                .id(1)
                .name("Renan Mafort Sereia 2")
                .build();
    }
}
