package br.com.devdojo.varargs.datasemjava.dates.formatacao;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormates {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] df = new DateFormat[7];
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateTimeInstance();
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println("Calendar" + calendar);
        System.out.println("Calendar" + calendar.getTime());
        for (DateFormat dt: df) {
            System.out.println(dt.format(calendar.getTime()));
        }
    }
}
