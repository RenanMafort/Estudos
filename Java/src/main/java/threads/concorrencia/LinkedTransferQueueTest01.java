package threads.concorrencia;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Object> tq = new LinkedTransferQueue<>();

        System.out.println(tq.remainingCapacity());

        System.out.println();

        System.out.println(tq.add("Renan"));
        System.out.println(tq.offer("Renan"));
        System.out.println(tq.offer("Renan",10, TimeUnit.SECONDS));
        tq.put("Devdojo");
        tq.transfer("Sereia");
        System.out.println(tq.remainingCapacity());
    }
}
