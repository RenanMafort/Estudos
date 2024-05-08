package br.com.devdojo.varargs.threads.treinando.concorrencia;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count;

    AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock();
     void increment(){
         lock.lock();
        try{
            count++;
            atomicInteger.incrementAndGet();
        } finally {
            lock.unlock();

        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
public class AtomicIntegerTeste01 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("COUNTER -> " + counter.getCount());
        System.out.println("COUNTER ATOMIC INTEGER -> " + counter.getAtomicInteger());

    }
}
