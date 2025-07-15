package melhorias.thread.concorrencia.reentrantlock.wait.notify.notifyall;

public class EmailDeliveryService implements Runnable {
    private Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " starting to deliver emails...");

        while (members.isOpen() || members.pendingEmails() > 0){
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(name + " enviando email para " + email);
                Thread.sleep(2000);
                System.out.println(name + " enviou email com sucesso para " + email);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
