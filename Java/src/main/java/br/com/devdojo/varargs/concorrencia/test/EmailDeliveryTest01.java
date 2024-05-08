package br.com.devdojo.varargs.concorrencia.test;


import br.com.devdojo.varargs.concorrencia.test.dominio.Members;
import br.com.devdojo.varargs.concorrencia.test.services.EmailDeliveryService;


import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), " Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), " Kakashi");

        jiraya.start();
        kakashi.start();

        while (true){
            String entreComOSeuEmail = JOptionPane.showInputDialog("Entre com o seu email");
            if (entreComOSeuEmail == null || entreComOSeuEmail.isBlank()){
                members.close();
                break;
            }
            members.addMemberEmail(entreComOSeuEmail);

        }
    }
}
