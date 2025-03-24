package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.AirCraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AirCraftSingletonEagerLazyt01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AirCraftSingletonLazy.getInstance());
        System.out.println(AirCraftSingletonLazy.getInstance());

        Constructor<AirCraftSingletonLazy> declaredConstructor = AirCraftSingletonLazy.class.getDeclaredConstructor(Integer.class);
        declaredConstructor.setAccessible(Boolean.TRUE);
        AirCraftSingletonLazy airCraftSingletonLazy = declaredConstructor.newInstance(2);
        System.out.println(airCraftSingletonLazy);
    }

    private static void bookSeat(String seat){
        AirCraftSingletonLazy airCraftSingletonLazy = AirCraftSingletonLazy.getInstance();
        System.out.println(airCraftSingletonLazy.bookSeat(seat));

    }
}
