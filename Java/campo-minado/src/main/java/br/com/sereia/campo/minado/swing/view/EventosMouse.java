package br.com.sereia.campo.minado.swing.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface EventosMouse extends MouseListener {

    @Override
    void mouseClicked(MouseEvent e);

    @Override
    void mousePressed(MouseEvent e);

    @Override
    void mouseReleased(MouseEvent e);

    @Override
    void mouseEntered(MouseEvent e);

    @Override
    void mouseExited(MouseEvent e);
}
