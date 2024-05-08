package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> list = new ArrayList<>();
        list.add(new Manga(1L,"Renan",22.23,0));
        list.add(new Manga(3L,"MAFORT",43.22,2));
        list.add(new Manga(2L,"SEREIA",13.56,7));
        list.add(new Manga(5L,"TESTENADO",18.66,3));
        list.add(new Manga(4L,"TEST",11.05,1));

//        Iterator<Manga> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Manga next = iterator.next();
//            if (next.getQuantidade()==0){
//                iterator.remove();
//            }
//        }
//
//        list.removeIf(mg -> mg.getNome().trim().equalsIgnoreCase("TESTENADO "));
//
//        for (Manga mg: list
//             ) {
//            System.out.println(mg);
//        }

        for (Manga manga : list) {
               list.remove(manga);

        }

    }
}
