package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.Person;

public class BuildPatternTest01 {
    public static void main(String[] args) {
        Person build =Person.PersonBuilder.builder()
                .firstName("Renan")
                .lastName("Sereia")
                .userName("Renante10")
                .email("Renan@ff")
                .build();

        System.out.println(build);


    }
}
