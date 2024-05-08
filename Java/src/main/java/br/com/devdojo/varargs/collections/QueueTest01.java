package br.com.devdojo.varargs.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("c");
        fila.add("b");
        fila.add("a");

        System.out.println(fila.poll());
        System.out.println(fila.peek());

    }
}
