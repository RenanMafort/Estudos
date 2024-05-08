package br.com.sereia.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Observador {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Observador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,200);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null); // null ceetraliza no meio da tela do PC;

        JButton button = new JButton("Click");
        frame.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Clicooou !!");
//            }
//        });

        button.addActionListener((e) -> System.out.println("Clicooou !!"));
        frame.setVisible(true);
    }
}
