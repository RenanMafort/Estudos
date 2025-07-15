package br.com.devdojo.varargs.datasemjava.dates;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTEST01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(1999, Month.MARCH,22,14, 0, 1);
        LocalDateTime now =LocalDateTime.now();
        System.out.println(aniversario);

        Long chronoUnit = ChronoUnit.DAYS.between(aniversario,now);
        Long chronoUnit1 = ChronoUnit.YEARS.between(aniversario,now);
        Long chronoUnit2= ChronoUnit.MONTHS.between(aniversario,now);
        System.out.println(chronoUnit / 365);
        System.out.println(chronoUnit1);
        System.out.println(chronoUnit2);


    }
}
