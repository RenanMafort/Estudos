package melhorias.thread.executors;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorTest02 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper(){
        Runnable runnable = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

//        executor.schedule(runnable,5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(runnable, 1, 5, TimeUnit.SECONDS);
//        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);
        executor.schedule(()  ->{
            System.out.println("Cancelando o scheduledFuture");
            scheduledFuture.cancel(false);
            executor.shutdown();
        },20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter) + " inicio");
        beeper();

    }
}
