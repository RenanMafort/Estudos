package melhorias.thread.concorrencia.atomic.reentrantlock.wait.notify.notifyall;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails =  new ArrayBlockingQueue<>(10);
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();
    private boolean open = true;

    public boolean isOpen(){
        return this.open;
    }

    public int pendingEmails(){
       lock.lock();

       try {
           return emails.size();
       }finally {
           lock.unlock();
       }
    }

    public void addEmails(String email){
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email a fila");
            this.emails.add(email);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }


    public String retrieveEmail() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " checando se tem emails");
        try {
            while (this.emails.isEmpty()){
                if(!open){
                    return null;
                }
                System.out.println(Thread.currentThread().getName() + " Não tem emails disponiveis na lista, entrando em modo de espera!");
                condition.await();
            }
            return this.emails.poll();
        }finally {
            lock.unlock();
        }
    }

    public void close(){
        lock.lock();
       try {
           open = false;
           System.out.println(Thread.currentThread().getName() + " Notificando todos que não estamos recebendo mais emails!");
       }finally {
           lock.unlock();
       }

    }

    private void lock(){
        try{
            lock.lock();
        }finally {
            lock.unlock();
        }
    }


}
