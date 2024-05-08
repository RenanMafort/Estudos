package br.com.devdojo.varargs.threads.treinando.concorrencia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Work implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Work(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()){
                System.out.printf("Thread %s entrou em uma sessão critica %n",name);
            }
            System.out.printf("%d Threads esperando na fila %n",lock.getQueueLength());
            System.out.printf("Thread %s vai esperar por 2 segundos.%n",name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

public class ReentrantLockTest01  {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        new Thread(new Work("A",lock)).start();
        new Thread(new Work("B",lock)).start();
        new Thread(new Work("C",lock)).start();
        new Thread(new Work("D",lock)).start();
        new Thread(new Work("E",lock)).start();
        new Thread(new Work("F",lock)).start();
    }

}
