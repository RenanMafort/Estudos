package br.com.devdojo.varargs.threads.treinando.threads;

public class DeadLock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Runnable r1 = () -> {
          synchronized (object1){
              System.out.println("Primeira THREAD segurando o object1");
              System.out.println("Primeira THREAD esperando o object2");
              synchronized (object2){
                  System.out.println("Primeira THREAD segurando o object2");

              }
          }
        };


        Runnable r2 = () -> {
            synchronized (object2){
                System.out.println("Segunda THREAD segurando o object2");
                System.out.println("Segunda THREAD esperando o object1");
                synchronized (object1){
                    System.out.println("Segunda THREAD segurando o object1");

                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
