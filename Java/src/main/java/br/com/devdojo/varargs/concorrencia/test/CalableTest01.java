package br.com.devdojo.varargs.concorrencia.test;

import java.util.concurrent.*;

class  RandonNumberCallable implements Callable<String>{
    @Override
    public String call()  {

        Math.random();
        int count = ThreadLocalRandom.current().nextInt(1,11);
        for (int i = 0; i < count; i++) {
            System.out.printf("%s executando uma tarefa callable%n",Thread.currentThread().getName());

        }
        return String.format("%s finished and the randon number is %d",Thread.currentThread().getName(),count);
    }

}
public class CalableTest01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        RandonNumberCallable randonNumberCallable = new RandonNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(randonNumberCallable);
        String s = submit.get();

        System.out.printf("Program finished %s",s);
        executorService.shutdown();
    }

}
