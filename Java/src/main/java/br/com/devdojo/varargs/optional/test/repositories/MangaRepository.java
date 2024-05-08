package br.com.devdojo.varargs.optional.test.repositories;

import br.com.devdojo.varargs.optional.test.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static final List<Manga> mangas = List.of(new Manga(1,"Renan",  50),new Manga(2,"Renan",  50),new Manga(3,"Renan",  50));

    public  static Optional<Manga> findById(Integer id){
       return findBy(m -> m.getId().equals(id));

    }
    public  static Optional<Manga> findByTitle(String title){
        return findBy(m -> m.getTitle().equals(title));

    }

    public static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga found = null;
        for (Manga manga : mangas) {
            if (predicate.test(manga)){
                found = manga;
            }
        }

        return Optional.ofNullable(found);

    }

}
