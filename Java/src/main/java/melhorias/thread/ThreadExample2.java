package melhorias.thread;

class ThreadTeste2 extends Thread {
    private char c;

    public ThreadTeste2(char c){
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

class ThreadRunnable2 implements Runnable{
    private char c;

    public ThreadRunnable2(char c){
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

            Thread.yield();
        }
    }
}

public class ThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadRunnable2('A'),"T1");
        Thread t2 = new Thread(new ThreadRunnable2('B'),"T2");

        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t2.join();

    }
}
