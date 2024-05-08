package br.com.sereia.swing.calculadora.view;

import br.com.sereia.swing.calculadora.model.Memoria;
import br.com.sereia.swing.calculadora.model.MemoriaObservador;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoriaObservador {
    private JLabel label ;

    public Display(){
        Memoria.getInstance().addObservador(this);

        setBackground(new Color(46,49,50));
        this.label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier",Font.PLAIN,30));
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
        add(label);
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
