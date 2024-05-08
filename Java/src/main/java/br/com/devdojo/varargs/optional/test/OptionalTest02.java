package br.com.devdojo.varargs.optional.test;

import br.com.devdojo.varargs.optional.test.dominio.Manga;
import br.com.devdojo.varargs.optional.test.repositories.MangaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalTest02 {
    public static void main(String[] args) {
        MangaRepository.findByTitle("Renan").ifPresent( title -> title.setTitle("RENAN_ALT"));

        Optional<Manga> findTitle = MangaRepository.findByTitle("RENAN_ALT");
        System.out.println(findTitle);

//        Optional<Manga> byId = MangaRepository.findById(10);
//        byId.orElseThrow(IllegalArgumentException::new);
//        System.out.println(byId);

        Manga manga = MangaRepository.findByTitle("RENAN_ALT2asdasd")
                .orElseGet(() -> new Manga(4, "RENAN_ALT2", 40));
        System.out.println(manga);

    }
}
