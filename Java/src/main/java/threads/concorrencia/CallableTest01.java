package threads.concorrencia;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        int cont = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i< cont;i++){
            System.out.printf("%s executando uma tarefa callable...",Thread.currentThread().getName());

        }
        return String.format("%s finished and the random is %d",Thread.currentThread().getName(),cont);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(randomNumberCallable);
        String s = submit.get();

        System.out.printf("Program finished %s",s);

    }
}
