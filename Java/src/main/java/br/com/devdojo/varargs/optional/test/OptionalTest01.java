package br.com.devdojo.varargs.optional.test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha uhu");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

        System.out.println("-----------------------");
        Optional<String> rennan = findName("Rennas  ");

        rennan.ifPresent(System.out::println);

        rennan.orElseThrow(ArrayIndexOutOfBoundsException::new);

//        System.out.println(rennan);
//        String empty = rennan.orElse("EMPTY");
//        rennan.ifPresent((s) -> System.out.println(s.toUpperCase()));
//        System.out.println(empty);


    }
    private static Optional<String> findName(String name){
        List<String> list = List.of("Renna", "Sereia");
        int i = list.indexOf(name);
        if (i != -1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
