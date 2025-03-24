package br.com.devdojo.varargs.threads.concorrencia;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsServiceTest01 {
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static  void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(dtf) + " beep");
        };

//        SCHEDULED_EXECUTOR_SERVICE.schedule(r, 5,TimeUnit.SECONDS);
//        SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(r,1,5,TimeUnit.SECONDS);
        ScheduledFuture<?> teste = SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(r,1, 5, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(dtf));
        beeper();
    }
}
