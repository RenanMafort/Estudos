package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonEnum;
import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonLazy;

public class AirCraftSingeltonEnumTest01 {
    public static void main(String[] args) {
        bookSeat("IC");

    }

    private static void bookSeat(String seat){
        System.out.println(AirCraftSingletonEnum.INSTANCE.hashCode());
        AirCraftSingletonEnum instance = AirCraftSingletonEnum.INSTANCE;
        System.out.println(AirCraftSingletonEnum.NEWINSTANCE);
        System.out.println(instance.bookSeat(seat));
        System.out.println(instance.hashCode());
        System.out.println(instance.hashCode());

    }
}
