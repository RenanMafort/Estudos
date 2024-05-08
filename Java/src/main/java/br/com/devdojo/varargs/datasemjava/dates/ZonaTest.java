package br.com.devdojo.varargs.datasemjava.dates;

import java.time.*;
import java.util.Map;

public class ZonaTest {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);
        System.out.println(ZoneId.systemDefault());
        ZoneId zonaTokio = ZoneId.of("Asia/Tokyo");
        System.out.println(zonaTokio);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = localDateTime.atZone(zonaTokio);
        System.out.println(zonedDateTime);
        System.out.println(localDateTime.plusHours(9));

        Instant nowInstant =Instant.now();
        System.out.println(nowInstant);
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(zonaTokio);
        System.out.println(zonedDateTime1);

        System.out.println(ZoneOffset.MAX);
        System.out.println(ZoneOffset.MIN);
        ZoneOffset of = ZoneOffset.of("-04:00");
        OffsetDateTime offsetDateTime = localDateTime.atOffset(of);
        System.out.println(offsetDateTime);


    }
}
