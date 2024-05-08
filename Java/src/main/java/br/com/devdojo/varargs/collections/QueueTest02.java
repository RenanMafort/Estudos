package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.Consumidor;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class castToComparable implements Comparator<Consumidor>{

    @Override
    public int compare(Consumidor o1, Consumidor o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
public class QueueTest02 {
    public static void main(String[] args) {
        Consumidor c1 = new Consumidor("Renan Serea");
//        Queue<Consumidor> fila = new PriorityQueue<>(new castToComparable());
//        fila.add(c1);

        Queue<Consumidor> fila = new PriorityQueue<>();
        fila.add(c1);


    }
}
