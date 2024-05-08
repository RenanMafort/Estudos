package br.com.devdojo.varargs.datasemjava.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Date;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(22,32,22);
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime1.getHour());
        System.out.println(localTime1.getSecond());
        System.out.println(localTime1.get(ChronoField.HOUR_OF_AMPM));
    }
}
