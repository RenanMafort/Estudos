package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Consumidor;
import br.com.devdojo.varargs.collections.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {

        Consumidor c1 = new Consumidor("renan");
        Consumidor c2 = new Consumidor("sereia");

        Manga manga1 = new Manga(1L, "Renan", 22.23, 0);
        Manga manga2 = new Manga(3L, "MAFORT", 43.22, 2);
        Manga manga3 = new Manga(2L, "SEREIA", 13.56, 7);
        Manga manga4 = new Manga(5L, "TESTENADO", 18.66, 2);
        Manga manga5 = new Manga(4L, "TEST", 11.05, 1);

        Map<Consumidor,Manga> consumidorMangaMap = new HashMap<>();

        consumidorMangaMap.put(c1,manga2);
        consumidorMangaMap.put(c2,manga3);
        consumidorMangaMap.put(c2,manga1);
        consumidorMangaMap.put(c1,manga4);
        consumidorMangaMap.put(c1,manga5);

        for (Map.Entry<Consumidor,Manga> itens : consumidorMangaMap.entrySet()){
            System.out.println(itens.getKey() + ": " + itens.getValue());
        }
    }
}
