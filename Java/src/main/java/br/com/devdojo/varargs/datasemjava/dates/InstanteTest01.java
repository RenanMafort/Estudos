package br.com.devdojo.varargs.datasemjava.dates;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstanteTest01 {
    public static void main(String[] args) {
        Instant instant =Instant.now();
        System.out.println(LocalDateTime.now());
        System.out.println(instant);
        System.out.println(instant.getNano());
        System.out.println(instant.getEpochSecond());
        System.out.println(Instant.ofEpochSecond(3,1_000_000_000));
        System.out.println(Instant.ofEpochSecond(43,1_000_000_000));
    }
}
