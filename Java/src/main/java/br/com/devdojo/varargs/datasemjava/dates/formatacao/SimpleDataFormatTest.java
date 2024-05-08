package br.com.devdojo.varargs.datasemjava.dates.formatacao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatTest {
    public static void main(String[] args) {

        String pattern = "'country' 'Horario' yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        SimpleDateFormat sfd = new SimpleDateFormat(pattern);
        System.out.println(sfd.format(new Date()));


    }
}
