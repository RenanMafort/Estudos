package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraft;

public class AirCraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1B");
    }

    private static void bookSeat(String seat){
        AirCraft airCraft = new AirCraft("787-900");
        System.out.println(airCraft.bookSeat(seat));
    }
}
