package br.com.devdojo.varargs.classesinternas;

import br.com.devdojo.varargs.generics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList =new ArrayList<>(List.of(new Barco("Canoa"), new Barco("lancha")));
        barcoList.sort(Comparator.comparing(Barco::getNome));

        barcoList.sort(Comparator.comparing(Barco::getNome));

    }
}
