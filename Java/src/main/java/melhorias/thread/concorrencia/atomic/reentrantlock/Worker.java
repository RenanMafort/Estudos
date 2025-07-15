package melhorias.thread.concorrencia.atomic.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }


    @Override
    public void run() {
        try{
            lock.tryLock(2,TimeUnit.SECONDS);
            if (lock.isHeldByCurrentThread()){
                System.out.printf("Thread %s entrou em uma sessão critica%n",name);
            }

            System.out.printf("%d Threads esperando na fila%n",lock.getQueueLength());
            System.out.printf("Thread %s vai esperar 2s%n",name);
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Thread %s finalizou a espera%n",name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

           if (lock.isHeldByCurrentThread()){
               lock.unlock();
           }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A",lock)).start();
        new Thread(new Worker("B",lock)).start();
        new Thread(new Worker("C",lock)).start();
        new Thread(new Worker("D",lock)).start();
        new Thread(new Worker("E",lock)).start();
        new Thread(new Worker("F",lock)).start();
    }
}
