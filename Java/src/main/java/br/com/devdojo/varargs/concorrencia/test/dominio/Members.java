package br.com.devdojo.varargs.concorrencia.test.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean open = true;

    public boolean isOpen(){
        return open;
    }

    public int pendingEmails(){
        lock.lock();

        try {
            return emails.size();
        }finally {
            lock.unlock();
        }
    }

    public void addMemberEmail(String email){
        lock.lock();
        try {
                String name = Thread.currentThread().getName();
                System.out.println(name + " Adicionou email na lista! ");
                this.emails.add(email);
                condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +" checking if there are emails");
       lock.lock();
       try {
            while (this.emails.size() ==0){
                if (!open) return null;
                System.out.println(Thread.currentThread().getName()+ " Não tem email disponivel na lista, entrando em modo de espera");
                condition.await();
            }

            return this.emails.poll();
        }finally {
           lock.unlock();
       }
    }

    public void close(){
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notifying everyone that we aren't receiving emails ");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
