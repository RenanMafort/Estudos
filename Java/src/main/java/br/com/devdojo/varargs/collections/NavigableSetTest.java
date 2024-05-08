package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Manga;
import br.com.devdojo.varargs.collections.dominio.SmartPhone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartPhoneTest implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o,SmartPhone o2) {
        return o.getMarca().compareTo(o2.getMarca());
    }
}

class MangaComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getValor(),o2.getValor());
    }
}
public class NavigableSetTest {
    public static void main(String[] args) {
        NavigableSet<SmartPhone> mangas = new TreeSet<>(new SmartPhoneTest());
        SmartPhone smartPhone = new SmartPhone("123", "Samsung");
        mangas.add(smartPhone);

        NavigableSet<Manga> mangas1 = new TreeSet<>(new MangaComparator());
        mangas1.add(new Manga(1L,"Renan",22.23,0));
        mangas1.add(new Manga(3L,"MAFORT",43.22,2));
        mangas1.add(new Manga(2L,"SEREIA",13.56,7));
        mangas1.add(new Manga(5L,"TESTENADO",18.66,3));
        mangas1.add(new Manga(4L,"TEST",11.05,1));
        System.out.println(mangas1);

        for (Manga manga : mangas1.descendingSet()) {
            System.out.println(manga);
        }

        Manga sereia = new Manga(2L, "SEREIA", 15.00, 7);
        //lower <
        //floor <=
        //higher >
        //ceiling >=
        System.out.println("------------");
        System.out.println(mangas1.lower(sereia));
        System.out.println(mangas1.floor(sereia));
        System.out.println(mangas1.higher(sereia));
        System.out.println(mangas1.ceiling(sereia));

        System.out.println(mangas1.pollFirst()); //pega o primeiro da lista e remove

    }
}
