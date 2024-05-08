package br.com.devdojo.varargs.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaFunction {
    public static void main(String[] args) {
        List<String> renan = List.of("renan", "mafort", "sereia");
        List<Integer> map = map(renan, (String::length));
        List<String> map1 = map(renan, s -> s.toUpperCase());
        System.out.println(map);
        System.out.println(map1);
    }
    private static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> resut = new ArrayList<>();
        for (T t: list){
            R apply = function.apply(t);
            resut.add(apply);
        }
        return resut;
    }

    private static <R>  List<R> mape(List<R> list){
        List<R> resulte = new ArrayList<>();
        for (R result: list){
            resulte.add(result);
        }

        return resulte;
    }


}
