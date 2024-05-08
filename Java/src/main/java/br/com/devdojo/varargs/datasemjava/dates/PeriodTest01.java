package br.com.devdojo.varargs.datasemjava.dates;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate nowAdterTwoYears = LocalDate.now().plusYears(2).plusDays(4).plusMonths(2);
        Period period = Period.between(localDate,nowAdterTwoYears);
        Period p2 = Period.ofDays(10);
        Period p3= Period.ofWeeks(10);

        System.out.println(p2);
        System.out.println(period);
    }
}
