package br.com.devdojo.varargs.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AirCraftSingletonEager {

    //Eager initialization
//    private  final AirCraftSingletonEager INSTANCE = new AirCraftSingletonEager("787-900");

    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public AirCraftSingletonEager(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
        availableSeats.add("1C");
    }

//    public static AirCraftSingletonEager getInstance(){
//        return INSTANCE;
//    }
    public boolean bookSeat(String seats){
        this.availableSeats.forEach(System.out::println);
        return availableSeats.remove(seats);
    }

    @Override
    public String toString() {
        return "AirCraftSingletonEager{" +
                "availableSeats=" + availableSeats +
                ", name='" + name + '\'' +
                '}';
    }
}
