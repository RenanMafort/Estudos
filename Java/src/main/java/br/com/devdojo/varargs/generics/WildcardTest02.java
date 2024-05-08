package br.com.devdojo.varargs.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WildcardTest02 {

    public static void main(String[] args) {

        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Mamifero> gatos = new ArrayList<>(List.of(new Gato(), new Cachorro()));
        List<Mamifero> animais = new ArrayList<>(List.of(new Gato(), new Cachorro()));
        List<Gato> gatos1 = List.of(new Gato(), new Gato());

        printConsulta(cachorros);
        printConsulta(gatos1);

        printConsultaAnimal(gatos);

    }

    private static void printConsulta(List<? extends Animal> animals){
        for (Animal animal : animals){
            animal.consuta();
        }
//        animals.add(new Gato());
//        animals.add(new Cachorro());

    }

    private static void printConsultaAnimal(List<? super Animal> animals){
        animals.add(new Gato());
        animals.add(new Cachorro());

    }
}

