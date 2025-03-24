package br.com.devdojo.varargs.streams.dominios.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.*;

public class StreamTest09 {
    public static void main(String[] args) {
//        IntStream.rangeClosed(1,50).filter( n -> n %2==0).forEach( n -> System.out.print(n + " "));

//        System.out.println();
//        IntStream.range(1,50).filter( n -> n %2==0).forEach( n -> System.out.print(n + " "));
//        System.out.println();
        Stream.of("Renan","Sereia","Mafort").map(x -> x.toUpperCase()).forEach(s -> System.out.print(s + " "));
        Arrays.stream(new int[]{2,4,5,616,161,161}).mapToObj(n -> n> 5).forEach(System.out::println);
//
//        int num[] = {1,2,3,4,5};
//        Arrays.stream(num).average().ifPresent(System.out::println);
//
//        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
//           lines.filter(l -> l.contains("JAVA")).forEach(s -> System.out.println(s));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        IntStream.range(1,50).mapToObj(n -> n % 2 == 0).forEach(System.out::println);

    }
}
