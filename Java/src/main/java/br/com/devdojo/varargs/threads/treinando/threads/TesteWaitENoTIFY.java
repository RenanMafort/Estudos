package br.com.devdojo.varargs.threads.treinando.threads;

import br.com.devdojo.varargs.threads.treinando.threads.dominio.Members;
import br.com.devdojo.varargs.threads.treinando.threads.service.Service;

import javax.swing.*;

public class TesteWaitENoTIFY {
    public static void main(String[] args) {
        Members members = new Members();
        Thread renan = new Thread(new Service(members), "Renan");
        Thread wilker = new Thread(new Service(members), "Wilker");
        renan.start();
        wilker.start();
        while (true){
            String email = JOptionPane.showInputDialog("Entre com seu email!");
            if (email == null || email.isEmpty()) {
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
