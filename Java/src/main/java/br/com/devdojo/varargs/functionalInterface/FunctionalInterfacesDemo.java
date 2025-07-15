package br.com.devdojo.varargs.functionalInterface;

import java.util.function.*;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // Predicate
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println("Predicate: " + isNotEmpty.test("Java"));

        // Consumer
        Consumer<String> print = s -> System.out.println("Consumer: Olá, " + s);
        print.accept("Mundo");

        // Supplier
        Supplier<String> greeting = () -> "Supplier: Bom dia!";
        System.out.println(greeting.get());

        // Function
        Function<String, Integer> length = s -> s.length();
        System.out.println("Function: Tamanho = " + length.apply("Java"));

        // UnaryOperator
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("UnaryOperator: " + square.apply(5));

        // BinaryOperator
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("BinaryOperator: " + sum.apply(3, 4));

        // BiFunction
        BiFunction<String, String, Integer> totalLength = (a, b) -> a.length() + b.length();
        System.out.println("BiFunction: " + totalLength.apply("Oi", "Java"));

        // BiConsumer
        BiConsumer<String, Integer> printTwice = (s, i) -> System.out.println("BiConsumer: " + s + " " + i);
        printTwice.accept("Idade:", 30);

        // BooleanSupplier
        BooleanSupplier isOk = () -> true;
        System.out.println("BooleanSupplier: " + isOk.getAsBoolean());

        // IntPredicate
        IntPredicate isEven = i -> i % 2 == 0;
        System.out.println("IntPredicate: " + isEven.test(4));

        // IntSupplier
        IntSupplier answer = () -> 42;
        System.out.println("IntSupplier: " + answer.getAsInt());

        // IntFunction
        IntFunction<String> convert = i -> "IntFunction: Número: " + i;
        System.out.println(convert.apply(7));

        // IntUnaryOperator
        IntUnaryOperator triple = i -> i * 3;
        System.out.println("IntUnaryOperator: " + triple.applyAsInt(3));

        // IntBinaryOperator
        IntBinaryOperator multiply = (a, b) -> a * b;
        System.out.println("IntBinaryOperator: " + multiply.applyAsInt(2, 4));

        // DoublePredicate
        DoublePredicate isPositive = d -> d > 0;
        System.out.println("DoublePredicate: " + isPositive.test(5.5));

        // DoubleFunction
        DoubleFunction<String> doubleToString = d -> "DoubleFunction: Valor = " + d;
        System.out.println(doubleToString.apply(3.14));

        // DoubleUnaryOperator
        DoubleUnaryOperator halve = d -> d / 2;
        System.out.println("DoubleUnaryOperator: " + halve.applyAsDouble(10.0));

        // DoubleBinaryOperator
        DoubleBinaryOperator add = (a, b) -> a + b;
        System.out.println("DoubleBinaryOperator: " + add.applyAsDouble(1.1, 2.2));

        // ToIntFunction
        ToIntFunction<String> strLength = s -> s.length();
        System.out.println("ToIntFunction: " + strLength.applyAsInt("Java"));

        // ToLongFunction
        ToLongFunction<String> strToLong = s -> (long) s.length();
        System.out.println("ToLongFunction: " + strToLong.applyAsLong("Java"));

        // ToDoubleFunction
        ToDoubleFunction<String> strToDouble = s -> s.length() * 1.5;
        System.out.println("ToDoubleFunction: " + strToDouble.applyAsDouble("Java"));
    }
}
