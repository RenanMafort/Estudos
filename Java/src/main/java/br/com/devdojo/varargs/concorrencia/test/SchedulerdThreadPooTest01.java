package br.com.devdojo.varargs.concorrencia.test;

import br.com.devdojo.varargs.enums.Main;

import javax.swing.text.DateFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerdThreadPooTest01 {
    private static final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

    private static final DateTimeFormatter formatter =DateTimeFormatter.ofPattern("HH:mm:ss");
    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

//        schedule.schedule(r,5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = schedule.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
        schedule.schedule(() -> {
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduledFuture.cancel(false);
            schedule.shutdown();
        },18,TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
