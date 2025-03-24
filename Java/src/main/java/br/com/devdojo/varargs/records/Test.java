package br.com.devdojo.varargs.records;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.Person;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(4,24,15,746,234,12);

        list.forEach((numero) -> {
            System.out.println("Renan");
            System.out.println("Sereia");
        });


    }
}
