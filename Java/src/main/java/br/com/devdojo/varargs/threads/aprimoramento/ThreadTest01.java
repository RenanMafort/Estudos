package br.com.devdojo.varargs.threads.aprimoramento;

class ThreadExample extends Thread{
    private char c;
    
    public ThreadExample(char c){
        this.c = c;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}

class ThreadExampleRunnable implements Runnable{
    private char c;

    public ThreadExampleRunnable(char c){
        this.c = c;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest01 {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');


        Thread t1 = new Thread(new ThreadExampleRunnable('A'),"T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'),"T2B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'),"T3C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'),"T4D");

        t3.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
