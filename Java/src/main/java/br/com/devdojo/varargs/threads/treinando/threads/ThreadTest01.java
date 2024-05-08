package br.com.devdojo.varargs.threads.treinando.threads;


import java.util.concurrent.TimeUnit;

class ThreadExample extends Thread{
    private char c;

    public ThreadExample(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("   "+ Thread.currentThread().getName());
        for (int i = 0; i  < 100; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        };
    }
}

class ThreadExampleRunnable implements Runnable {
    private char c;

    public ThreadExampleRunnable(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("   "+ Thread.currentThread().getName());
        for (int i = 0; i  < 100; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        Thread t1 = new Thread(new ThreadExampleRunnable('A'),"Threade A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'),"Threade B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'),"Threade C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'),"Threade D");

        t1.start();
        t2.start();
        t3.start();
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        System.out.println("###########################"+ Thread.currentThread().getName());
    }
}
