package br.com.devdojo.varargs.datasemjava.dates.formatacao;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        System.out.println(Locale.forLanguageTag("me"));

        Locale localeItaly = new Locale("it","IT");
//        Locale localeMexico = Locale.of("it","IT");
        Locale localeCH = new Locale("it","CH");
        Locale LocaleHindi = new Locale("hi","IN");
        Locale Localejapao = new Locale("ja","JP");
        Locale LocaleNetherlands = new Locale("nl","NL");
        Locale brasil = new Locale("pt","BR");

        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL,localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,localeCH);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL,LocaleHindi);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL,Localejapao);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL,LocaleNetherlands);
        DateFormat df6= DateFormat.getDateInstance(DateFormat.FULL,brasil);

        System.out.println("Italy " + df1.format(calendar.getTime()));
        System.out.println("Suiça " + df2.format(calendar.getTime()));
        System.out.println("India " + df3.format(calendar.getTime()));
        System.out.println("Japão " + df4.format(calendar.getTime()));
        System.out.println("Holanda " + df5.format(calendar.getTime()));
        System.out.println("Brasil " + df6.format(calendar.getTime()));

        System.out.println(LocaleHindi.getDisplayCountry(Localejapao));
        System.out.println(Localejapao.getDisplayCountry(LocaleHindi));
//        System.out.println(brasil.getDisplayCountry(localeMexico)); // Escreva "Brasil" em "Mexicano"
    }
}
