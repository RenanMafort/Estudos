package threads.aprimoramento.teste;

import threads.aprimoramento.dominio.Members;
import threads.aprimoramento.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        Members members = new Members();
        Thread renan = new Thread(new EmailDeliveryService(members), "Renan ");
        Thread sereia = new Thread(new EmailDeliveryService(members), "Sereia ");

        renan.start();
        sereia.start();

        while (true){
            String email = JOptionPane.showInputDialog("Entre com o seu email:");
            if (email == null || email.isEmpty()){
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
