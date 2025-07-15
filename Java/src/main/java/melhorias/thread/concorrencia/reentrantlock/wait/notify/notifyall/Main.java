package melhorias.thread.concorrencia.reentrantlock.wait.notify.notifyall;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Members members = new Members();

        Thread renan = new Thread(new EmailDeliveryService(members), "Renan");
        Thread sereia = new Thread(new EmailDeliveryService(members), "sereia");
        renan.start();
        sereia.start();

        while (true){
            String email = JOptionPane.showInputDialog("Entre com seu email");
            if (email == null || email.isBlank()){
                members.close();
                break;
            }

            members.addEmails(email);
        }
    }
}
