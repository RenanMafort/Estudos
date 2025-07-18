package melhorias.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{

    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %d%n",Thread.currentThread().getName(), num);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s finalizou%n",Thread.currentThread().getName());


    }
}

public class ExecutorsTest01 {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));

        executorService.shutdown();

        while (!executorService.isTerminated()){}

        System.out.println("Programa finalizado");
    }
}
