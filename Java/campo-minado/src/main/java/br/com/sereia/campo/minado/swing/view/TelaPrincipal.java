package br.com.sereia.campo.minado.swing.view;

import br.com.sereia.campo.minado.swing.model.Tabuleiro;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){
        Tabuleiro tabuleiro = new Tabuleiro(16,30,50);
        add(new PainelTabuleiro(tabuleiro));

        setTitle("Campo Minado");
        setSize(690,438);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
