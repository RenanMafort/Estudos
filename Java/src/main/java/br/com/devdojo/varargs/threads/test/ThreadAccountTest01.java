package br.com.devdojo.varargs.threads.test;

import br.com.devdojo.varargs.threads.dominio.Account;

public class ThreadAccountTest01 implements Runnable{
    private final Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0){
                System.out.println("FODEU");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01,"Renan ");
        Thread t2 = new Thread(threadAccountTest01,"Sereia ");

        t1.start();
        t2.start();
    }

    private  void withdrawal(int amount){
        System.out.println(Thread.currentThread().getName() + " ############# fora  do synchronized #############");
        synchronized (account){
        System.out.println(Thread.currentThread().getName() + " ************** dentro  do synchronized **************");
            if (account.getBalance() >= amount){
                System.out.println(Thread.currentThread().getName() + "está indo sacar dinheiro ");
                account.withdrawal(amount);
                System.out.println(Thread.currentThread().getName() + "completou o saque, valor atual da conta " + account.getBalance());
            }else {
                System.out.println("Saldo insuficiente para " + Thread.currentThread().getName() + "efetuar o saque " + account.getBalance());
            }
        }
    }
}
