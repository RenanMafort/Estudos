package br.com.devdojo.varargs.nio;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Integer> teste = List.of(1,2,3,4,5,6,7,8,9,10,11,12);
        int toIndex = 20 + 10;
        if (toIndex > teste.size()) {
            toIndex = teste.size();
        }

        System.out.println(teste.subList(20,toIndex));

    }
}
