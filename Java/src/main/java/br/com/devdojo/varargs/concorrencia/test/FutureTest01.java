package br.com.devdojo.varargs.concorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException,TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return  4.350;
        });
        System.out.println(doSomething());
        Double dollarResponse = dollarRequest.get(3,TimeUnit.SECONDS);
        System.out.println("Dollar "+dollarResponse);
        executorService.shutdown();
    }

    private static long doSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum+=1;
        }
        return sum ;
    }
}
