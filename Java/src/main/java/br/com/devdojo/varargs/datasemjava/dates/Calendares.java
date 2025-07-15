package br.com.devdojo.varargs.datasemjava.dates;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Calendares {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Calendar calenJapan = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);

        System.out.println(calendar.getTime());
        System.out.println("Japan First day - " + calenJapan.get(Calendar.DAY_OF_WEEK));

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
