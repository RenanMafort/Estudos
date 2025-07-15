package melhorias.thread.concorrencia.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();


    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getCount(){
        return this.count;
    }

    //Perde o conceito de multithread pois apenas uma vai acessar por vez
//    synchronized void increment(){
//        ++this.count;
//    }

    void increment(){
        ++this.count;
        this.atomicInteger.incrementAndGet();
    }



    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter - " + counter.getCount());
        System.out.println("AtomicInteger - " + counter.getAtomicInteger());

    }
}
