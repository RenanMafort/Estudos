package br.com.devdojo.varargs.collections;

import java.util.*;

public class ListaArrayConversao01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(2);
        numeros.add(2);
        numeros.add(3);
        numeros.add(0,3);

        Set<Integer> lista2 = new HashSet<>(numeros);
        for (Integer i: lista2
             ) {
            System.out.println(i);
        }

        Integer[] ListToArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(ListToArray));
//
        System.out.println("---------------");
        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);

        arrayToList.set(0,12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);

        System.out.println("-------------");
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        System.out.println(numerosList);

        List<Integer> integers = List.of();
        System.out.println(integers);
    }
}
