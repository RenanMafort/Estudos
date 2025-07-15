package melhorias.thread.future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 4.52D;
        });

        System.out.println(doSomething());

        Double dollarResponse = dollarRequest.get(3,TimeUnit.SECONDS);
        System.out.println("Dollar response: " + dollarResponse);

        executorService.shutdown();
    }

    public static long doSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        return sum;
    }
}
