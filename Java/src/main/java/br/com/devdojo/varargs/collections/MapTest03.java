package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Consumidor;
import br.com.devdojo.varargs.collections.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {

        Consumidor c1 = new Consumidor("renan");
        Consumidor c2 = new Consumidor("sereia");

        Manga manga1 = new Manga(1L, "Renan", 22.23, 0);
        Manga manga2 = new Manga(3L, "MAFORT", 43.22, 2);
        Manga manga3 = new Manga(2L, "SEREIA", 13.56, 7);
        Manga manga4 = new Manga(5L, "TESTENADO", 18.66, 2);
        Manga manga5 = new Manga(4L, "TEST", 11.05, 1);

        List<Manga> mangas = List.of(manga2,manga4,manga5);
        List<Manga> mangas2 = List.of(manga1,manga3,manga5);
        Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();
        consumidorMangaMap.put(c1,mangas);
        consumidorMangaMap.put(c2,mangas2);

        for (Map.Entry<Consumidor,List<Manga>> itens : consumidorMangaMap.entrySet()){
            System.out.println(itens.getKey());
            for (Manga manga: itens.getValue()){
                System.out.println(manga.getNome());
            }
        }
    }
}
