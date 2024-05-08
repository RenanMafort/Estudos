package br.com.devdojo.varargs.generics;

import br.com.devdojo.varargs.generics.dominio.Barco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> canoaMarota = criarArrayComUmObjeto(new Barco("Canoa Marota"),new Barco("Canoa Marota"),new Barco("Canoa Marota"));
        canoaMarota.forEach(System.out::println );
    }

    @SafeVarargs
    private static <T extends Serializable & Comparable<T> & AutoCloseable> List<T> criarArrayComUmObjeto(T... t){
        return List.of(t);
    }
}
