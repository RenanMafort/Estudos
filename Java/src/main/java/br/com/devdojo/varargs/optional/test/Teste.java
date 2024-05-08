package br.com.devdojo.varargs.optional.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Teste {
    public static void main(String[] args) {
        List<Integer>  n = Arrays.asList(1,2,3,4,5,6);
        Optional<String> o = Optional.of("teste");
        Optional<List<Integer>> o1 = Optional.of(Optional.of(n.stream().filter(p -> p % 2 == 0).collect(Collectors.toList()))
                .orElseThrow());
        System.out.println(o);
        System.out.println(o1);
    }
}
