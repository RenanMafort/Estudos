package br.com.devdojo.varargs.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AirCraftSingletonLazy {

    //Eager initialization
    private static  AirCraftSingletonLazy INSTANCE ;

    private final Set<String> availableSeats = new HashSet<>();
    private final Integer i;

    private AirCraftSingletonLazy(Integer i) {
        this.i = i;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
        availableSeats.add("1C");
    }

    public static AirCraftSingletonLazy getInstance(){
        if (INSTANCE ==null){
            synchronized (AirCraftSingletonLazy.class){
                if (INSTANCE ==null){
                    INSTANCE =  new AirCraftSingletonLazy(1);
                }
            }

        }
        return INSTANCE;
    }
    public boolean bookSeat(String seats){
        return availableSeats.remove(seats);
    }


}
