package br.com.sereia.swing.calculadora.view;

import javax.swing.*;
import java.awt.*;

public class Botao extends JButton {
    public Botao(String texto, Color color) {
        setText(texto);
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(color);
        setFont(new Font("courier",Font.PLAIN,20));
    }
}
