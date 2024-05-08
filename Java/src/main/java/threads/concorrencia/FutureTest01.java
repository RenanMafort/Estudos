package threads.concorrencia;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
          TimeUnit.SECONDS.sleep(2);
                return 4.350;
        });
        System.out.println(doingSomething());
        Double dollarResponse = dollarRequest.get();
        System.out.println("Dollar: " + dollarResponse);
        executorService.shutdown();
    }

    private static long doingSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += 1;
        }

        return sum;
    }
}
