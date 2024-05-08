package br.com.devdojo.varargs.optional.test.repositories;

import br.com.devdojo.varargs.optional.test.dominio.Livros;
import br.com.devdojo.varargs.optional.test.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepositorieForMe {
    static List<Livros> mangaList = List.of(new Livros("RENAN",20),new Livros("SEREIA",22),new Livros("MAFORT",2));

    public static Optional<Livros> findByTitle(String title){
        return findBy(livro -> livro.getTitle().equals(title));
    }
    private static Optional<Livros> findBy(Predicate<Livros> predicate){
        Livros livro = null;
        for (Livros livros : mangaList) {
            if (predicate.test(livros)){
                livro = livros;
            }
        }

        return Optional.ofNullable(livro);

    }
}
