package br.com.devdojo.varargs.datasemjava.dates;

import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date date = new Date(20L);
        date.toLocaleString();
        System.out.println("First - " + date);
        date.setTime(date.getTime() + 3_600_000 * 10);

        System.out.println("Today - " + date.getTime());
        System.out.println(date.getHours());
        System.out.println(date);

        Date date2 = new Date();
        System.out.println(date2.toString());

    }
}
