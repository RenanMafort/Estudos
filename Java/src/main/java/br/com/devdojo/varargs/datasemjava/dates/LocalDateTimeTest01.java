package br.com.devdojo.varargs.datasemjava.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDateTime1 = LocalDate.of(1999, Month.MARCH,22);
        LocalDate localDate = LocalDate.parse("2020-02-21");
        LocalTime localTime = LocalTime.parse("09:22:24");
        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));

        LocalDateTime date = localDate.atTime(localTime);
        String teste =date.toString().replace("T","");
        System.out.println(teste);
        System.out.println(date);
    }
}
