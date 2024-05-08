package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonEnum;
import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonLazy;

public class AirCraftSingeltonEnumTest01 {
    public static void main(String[] args) {

    }

    private static void bookSeat(String seat){
        System.out.println(AirCraftSingletonEnum.INSTANCE);
        AirCraftSingletonEnum instance = AirCraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));

    }
}
