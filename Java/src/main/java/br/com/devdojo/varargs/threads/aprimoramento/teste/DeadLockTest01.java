package br.com.devdojo.varargs.threads.aprimoramento.teste;

public class DeadLockTest01 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable r = () -> {
          synchronized (lock1){
              System.out.println("Thread 1: Segurando lock 1");
              System.out.println("Thread 1: Esperando lock 2");
              synchronized (lock2){
                  System.out.println("Thread 1: Segurando lock 2");
              }
          }
        };

        Runnable r2 = () -> {
            synchronized (lock2){
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2: Segurando lock 1");
                }
            }
        };
        new Thread(r,"RENAN").start();
        new Thread(r2,"SEREIA").start();
    }
}
