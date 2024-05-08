package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga m1, Manga m2) {
        return Long.compare(m1.getId(), m2.getId());
//        return Long.compare(m1.getId(), m2.getId());
    }}
public class MangasSortingTest01 {
    public static void main(String[] args) {
        List<Manga> list = new ArrayList<>();
        list.add(new Manga(1L,"Renan",22.23));
        list.add(new Manga(3L,"MAFORT",43.22));
        list.add(new Manga(2L,"SEREIA",13.56));
        list.add(new Manga(5L,"TESTENADO",18.66));
        list.add(new Manga(4L,"TEST",11.05));
//        Collections.sort(list, new MangaByIdComparator());
        Collections.sort(list, Comparator.comparingLong(Manga::getId));
        System.out.println(list);

        MangaByIdComparator comparator = new MangaByIdComparator();
        list.sort(comparator);
        list.sort(new MangaByIdComparator());
        System.out.println(list);
    }
}
