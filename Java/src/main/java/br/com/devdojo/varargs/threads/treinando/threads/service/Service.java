package br.com.devdojo.varargs.threads.treinando.threads.service;

import br.com.devdojo.varargs.threads.treinando.threads.dominio.Members;

public class Service implements Runnable {
    private final Members members;

    public Service(Members members) {
        this.members = members;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou o email delivery");
        while (members.isOpen() || members.pendingEmails() > 0 ){
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(Thread.currentThread().getName() + " enviando email para " + email);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
