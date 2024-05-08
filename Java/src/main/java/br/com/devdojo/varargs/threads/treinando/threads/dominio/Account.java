package br.com.devdojo.varargs.threads.treinando.threads.dominio;

public class Account {
    private int balance = 50;

    public void sacar(int amount){
       this.balance = this.balance - amount;
    }

    public int getBalance() {
        return balance;
    }
}
