package br.com.devdojo.varargs.streams.dominios.test;

import br.com.devdojo.varargs.streams.dominios.Category;
import br.com.devdojo.varargs.streams.dominios.LighNovel;
import br.com.devdojo.varargs.streams.dominios.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class StreamTest16 {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 10_000_000L;
        sumFor(num);
        sumStreamIterate(num);
        sumParalleStream(num);
        sumLongStream(num);
        sumParallelLongStream(num);

    }

    private static void sumFor(long num){
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i<= num; i++){
            result +=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end-init) +"ms");
    }
    private static void sumStreamIterate(long num){
        System.out.println("Sum StreamIterate");
        long init = System.currentTimeMillis();
        Long reduce = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(reduce + " " + (end-init) +"ms");
    }

    private static void sumParalleStream(long num){
        System.out.println("Sum sumParalleStream");
        long init = System.currentTimeMillis();
        Long reduce = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(reduce + " " + (end-init) +"ms");
    }

    private static void sumLongStream(long num){
        System.out.println("Sum sumLongStream");
        long init = System.currentTimeMillis();
        Long result = LongStream.rangeClosed(1L, num).reduce(0L,Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end-init) +"ms");
    }

    private static void sumParallelLongStream(long num){
        System.out.println("Sum sumParallelLongStream");
        long init = System.currentTimeMillis();
        Long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L,Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end-init) +"ms");
    }
}
