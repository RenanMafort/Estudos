package br.com.devdojo.varargs.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AirCraft {
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public AirCraft(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
        availableSeats.add("1C");
    }

    public String getName() {
        return name;
    }

    public boolean bookSeat(String seats){
        return availableSeats.remove(seats);
    }
}
