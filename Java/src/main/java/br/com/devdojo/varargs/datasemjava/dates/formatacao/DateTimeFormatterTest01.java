package br.com.devdojo.varargs.datasemjava.dates.formatacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format2 = localDate.format(DateTimeFormatter.ISO_DATE);
        String format3 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        LocalDate parse = LocalDate.parse("2022-03-22",DateTimeFormatter.ISO_DATE);
        System.out.println(parse);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String br = parse.format(formatter);
        System.out.println(br);
    }
}
