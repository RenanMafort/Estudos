package melhorias.thread.executors;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        int count = ThreadLocalRandom.current().nextInt(1,11);
        for (int i = 0; i < count; i++) {
            System.out.printf("%s executando uma tarefa callable...\n", Thread.currentThread().getName());
        }
        
        return String.format("%s finished and the random number is %d",Thread.currentThread().getName(),count);
    }
}

public class CallableTest {
    public static void main(String[] args) {

        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randomNumberCallable);
        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Program finished");

        executorService.shutdown();

    }
}
