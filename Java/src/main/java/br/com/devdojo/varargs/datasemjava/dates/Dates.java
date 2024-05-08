package br.com.devdojo.varargs.datasemjava.dates;

import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date date = new Date(1683558854611L);
        System.out.println(date);
        date.setTime(date.getTime() + 3_600_000 * 10);

        System.out.println("Today - " + date.getTime());
        System.out.println(date.getHours());
        System.out.println(date);
    }
}
