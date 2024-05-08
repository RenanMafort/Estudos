package threads.aprimoramento.teste;

import threads.aprimoramento.dominio.Account;

public class ThreadAccountTest01 implements Runnable {

    private final Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(15);
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadAccountTest01(), "Thread - Renan");
        Thread t2 = new Thread(new ThreadAccountTest01(), "Thread - Sereia");

        t1.start();
        t2.start();
    }

    private void withdrawal(int amount) {
        System.out.println(getThreadName() + " fora do synchronized");
        System.out.println(getThreadName() + " dentro do synchronized");
        if (account.getBalance() >= amount) {
            System.out.println(getThreadName() + " está indo sacar o dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque, valor da conta: " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para a " + getThreadName() + " efetuar o saque: " + account.getBalance());
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }


}
