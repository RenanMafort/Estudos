package br.com.devdojo.varargs.streams.dominios.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n-> n +2).limit(100_00).forEach(System.out::println);

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]}).limit(10).forEach(s -> System.out.println(Arrays.toString(s)));

        Stream.iterate(new int[]{0,1},  n -> new int[]{n[1], n[0] + n[1]})
                .map(a -> a[0]).limit(10).forEach(System.out::print);

//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        Stream.generate(() -> random.nextInt(0,100_000)).limit(100_000).forEach(System.out::println);
    }
}
