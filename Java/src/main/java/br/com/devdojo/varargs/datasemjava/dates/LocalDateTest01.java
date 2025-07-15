package br.com.devdojo.varargs.datasemjava.dates;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalDateTest01 {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());
        System.out.println(Month.MARCH.getValue());

        LocalDate localDate = LocalDate.of(2022,1,28);
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.lengthOfMonth());
        System.out.println(localDate.lengthOfYear());
        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
        System.out.println(localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));

        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
    }
}
