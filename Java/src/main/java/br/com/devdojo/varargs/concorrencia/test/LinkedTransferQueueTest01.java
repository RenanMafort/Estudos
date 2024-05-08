package br.com.devdojo.varargs.concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException{
        TransferQueue<Object> objects = new LinkedTransferQueue<>();
        System.out.println(objects.add("renan"));
        System.out.println(objects.offer("renan"));
        System.out.println(objects.offer("renan", 10,TimeUnit.SECONDS));
        objects.put("Sereia");
        if (objects.hasWaitingConsumer()){
            objects.transfer("Renan");
        }

        System.out.println(objects.remainingCapacity());
    }
}
