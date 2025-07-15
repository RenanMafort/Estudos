package br.com.devdojo.varargs.datasemjava.dates;

import java.util.Calendar;

public class Calendar2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());

        cal.add(Calendar.YEAR, -2);
        cal.set(Calendar.YEAR,2020);
        System.out.println(cal.getTime());

    }
}
