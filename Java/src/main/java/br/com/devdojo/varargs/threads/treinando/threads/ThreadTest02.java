package br.com.devdojo.varargs.threads.treinando.threads;

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

            Thread.yield();
        }
    }
}

//Daemon x User
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadEampleRunnable2("KA"),"Thread KA");
        Thread t2 = new Thread(new ThreadEampleRunnable2("ME"),"Thread ME");
        Thread t3 = new Thread(new ThreadEampleRunnable2("HA"),"Thread HA");

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("INICIOU A THREAD 1");
        t1.start();
        t1.join();
        System.out.println();
        System.out.println("INICIOU A THREAD 2");
        t2.start();
        t2.join();
        System.out.println();
        System.out.println("INICIOU A THREAD 3");
        t3.start();
        System.out.println();
        System.out.println("----------FIM-----------");

    }
}
