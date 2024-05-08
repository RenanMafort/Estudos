package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraft;
import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonEager;

public class AirCraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat){
        AirCraftSingletonEager airCraftSingletonEager = AirCraftSingletonEager.getInstance();
        System.out.println(airCraftSingletonEager.bookSeat(seat));

    }
}
