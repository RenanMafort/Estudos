package br.com.devdojo.varargs.datasemjava.dates.formatacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalTest02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3));

        Locale.setDefault(new Locale("en","US"));
        System.out.println(Locale.getDefault());
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();

        for (String isoLanguage: isoLanguages){
            System.out.print(isoLanguage + " ");
        }
        System.out.println();
        for (String isoCountrie: isoCountries){
            System.out.print(isoCountrie + " ");
        }

    }
}
