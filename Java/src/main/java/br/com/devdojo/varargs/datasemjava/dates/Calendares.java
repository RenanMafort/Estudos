package br.com.devdojo.varargs.datasemjava.dates;

import java.util.Calendar;
import java.util.Date;

public class Calendares {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingo");
        }

        System.out.println("Teste " + calendar.get(9));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH,2);

        Date date = calendar.getTime();
        System.out.println(calendar);
        System.out.println(date);
    }
}
