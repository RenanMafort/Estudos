package br.com.devdojo.varargs.threads;

class ThreadExample extends Thread {
    private char c;

    public ThreadExample(char c){
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

class ThreadEampleRunnable implements Runnable {

    private char c;

    public ThreadEampleRunnable(char c){
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//Daemon x User
public class ThreadTest01 {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        Thread t1 = new Thread(new ThreadEampleRunnable('A'),"THREAD 1");
        Thread t2 = new Thread(new ThreadEampleRunnable('B'),"THREAD 2");
        Thread t3 = new Thread(new ThreadEampleRunnable('C'),"THREAD 3");
        Thread t4 = new Thread(new ThreadEampleRunnable('D'),"THREAD 4");

        t4.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
