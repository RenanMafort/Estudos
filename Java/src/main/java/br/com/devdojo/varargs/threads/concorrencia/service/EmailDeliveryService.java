package br.com.devdojo.varargs.threads.concorrencia.service;


import br.com.devdojo.varargs.threads.concorrencia.dominio.Members;

public class EmailDeliveryService implements Runnable{

    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "Starting to delivery emails. ");
        while (members.isOpen()|| members.pendingEmails() > 0){
            try {
                String s = members.retrieverEmail();
                if (s == null) continue;
                System.out.println(threadName + " enviando email para "+s);

                Thread.sleep(2000);
                System.out.println(threadName + " enviou email com sucesso para" + s);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Todos os email foram enviados com sucesso!");
    }
}
