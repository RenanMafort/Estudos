package br.com.devdojo.varargs.datasemjava.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now.with(ChronoField.DAY_OF_MONTH,20);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
    }
}
