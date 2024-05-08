package br.com.devdojo.varargs.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AirCraftSingletonEnum {
    INSTANCE;

    private final Set<String> availableSeats;

    AirCraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    public boolean bookSeat(String seats){
        return availableSeats.remove(seats);
    }
}
