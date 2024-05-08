package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(1L,"Renan",22.23,0));
        mangas.add(new Manga(1L,"Renan2",22.13,1));
        mangas.add(new Manga(3L,"MAFORT",43.22,2));
        mangas.add(new Manga(2L,"SEREIA",13.56,7));
        mangas.add(new Manga(5L,"TESTENADO",18.66,3));
        mangas.add(new Manga(4L,"TEST",11.05,1));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
