package br.com.devdojo.varargs.threads.treinando.threads;

import br.com.devdojo.varargs.threads.treinando.threads.dominio.Account;

public class ThreadAccount implements Runnable {
    private final Account account = new Account();

    public static void main(String[] args) {
        ThreadAccount threadAccount = new ThreadAccount();
        Thread t1 = new Thread(threadAccount,"Renan Sereia");
        Thread t2 = new Thread(threadAccount,"Debora Lobo");
        t1.start();
        t2.start();
    }

    @Override
    public  void run() {
        for (int i = 0; i <= 5; i++) {
            sacar(10);
            if (account.getBalance() < 0){
                System.out.println("FODEOUUUUUUU");
            }
        }
    }

    private void sacar(int amount){
        System.out.println(getThreadName() + " esta fora do synchronized");
      synchronized (account){
          System.out.println(getThreadName() + " está dentro do synchronized!");
          System.out.println(getThreadName() + " está sacando o dinheiro!");
          if (account.getBalance() >= amount){
              account.sacar(amount);
              System.out.println(getThreadName() + " completou o saque. Saldo: " + account.getBalance());
          }else {
              System.out.println(getThreadName() + " não conseguiu sacar o dinheiro! Motivo: Saldo insuficiente!");

          }
      }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }




}
