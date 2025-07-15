package br.com.devdojo.varargs.datasemjava.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now =LocalDateTime.now();
        LocalDateTime nowAfterTwoYearas = LocalDateTime.now().plusYears(2).plusMinutes(45);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);

        Duration between = Duration.between(timeNow, nowAfterTwoYearas);
        System.out.println(between);
        LocalDate localDate = LocalDate.parse("2020-02-21");
        System.out.println(Duration.ofDays(22));
        System.out.println(Duration.ofMinutes(22));
        System.out.println(Duration.ofSeconds(1));
    }


}
