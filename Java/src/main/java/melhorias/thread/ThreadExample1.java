package melhorias.thread;

class ThreadTeste extends Thread {
    private char c;

    public ThreadTeste(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}

class ThreadRunnable implements Runnable{
    private char c;

    public ThreadRunnable(char c){
        this.c = c;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample1 {
    public static void main(String[] args) {
//        ThreadTeste t1 = new ThreadTeste('A');
//        ThreadTeste t2 = new ThreadTeste('B');
//        ThreadTeste t3 = new ThreadTeste('C');
//        ThreadTeste t4 = new ThreadTeste('D');

        Thread t1 = new Thread(new ThreadRunnable('A'),"T1A");
        Thread t2 = new Thread(new ThreadRunnable('B'),"T1B");
        Thread t3 = new Thread(new ThreadRunnable('C'),"T1C");
        Thread t4 = new Thread(new ThreadRunnable('D'),"T1D");

        t4.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
