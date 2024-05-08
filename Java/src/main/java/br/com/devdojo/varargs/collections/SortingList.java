package br.com.devdojo.varargs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingList {
    public static void main(String[] args) {
        long i =255L;
        List<String> list = new ArrayList<>(2);
        list.add("Abacate");
        list.add("Melancia");
        list.add("Bola");
        list.add("Teste");
        list.add("Renan");
        Collections.sort(list);
        for (String o:list
             ) {
            System.out.println(o);
        }

    }
}
