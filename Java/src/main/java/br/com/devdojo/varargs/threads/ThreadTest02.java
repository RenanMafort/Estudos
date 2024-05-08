package br.com.devdojo.varargs.threads;

class ThreadExample2 extends Thread {
    private char c;

    public ThreadExample2(char c){
        this.c =c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500 ; i++) {
            System.out.print(c);
            if (i % 100 ==0){
                System.out.println();
            }
        }
    }
}

class ThreadEampleRunnable2 implements Runnable {

    private String c;

    public ThreadEampleRunnable2(String c){
        this.c =c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500 ; i++) {
            System.out.print(c);
            if (i % 100 ==0){
                System.out.println();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//Daemon x User
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadEampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadEampleRunnable2("ME"));
        Thread t3 = new Thread(new ThreadEampleRunnable2("HA"));
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();


    }
}
