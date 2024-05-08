package br.com.sereia.campo.minado.swing.view;

import br.com.sereia.campo.minado.swing.model.Campo;
import br.com.sereia.campo.minado.swing.model.CampoEvento;
import br.com.sereia.campo.minado.swing.model.CampoObservador;
import br.com.sereia.campo.minado.swing.model.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class BotaoCampo extends JButton implements CampoObservador, EventosMouse {

    private Color BG_PADRAO = new Color(184,184,184);
    private Color BG_MARCAR = new Color(8,179,247);
    private Color BG_DEXPLODIR = new Color(189,66,88);
    private Color TEXTO_VERDE = new Color(0,100,0);

    private Campo campo;
    public BotaoCampo(Campo campo){
        this.campo = campo;
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        campo.registrarObservador(this);

        addMouseListener(this);//para pegar os eventos para o MouseListener
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento){
            case ABRIR -> aplicarEstiloAbrir();
            case MARCAR -> aplicarEstiloMarcar();
            case DESMARCAR -> aplicarEstiloDescarcar();
            case EXPLODIR -> aplicarEstiloExplodir();
            default -> aplicarEstiloPadrao();
        }
    }

    private void aplicarEstiloPadrao() {
        setBackground(BG_PADRAO);
        setText("");
        setBorder(BorderFactory.createBevelBorder(0));
    }

    private void aplicarEstiloAbrir() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (campo.isMinado()){
            setBackground(BG_DEXPLODIR);
            return;
        }

        setBackground(BG_PADRAO);
        switch ((int) campo.minasVizinhanca()){
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);
        }

        String valor = !campo.vizinhancaSegura() ? campo.minasVizinhanca() + "" : "";
        setText(valor);
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCAR);
        setText("M");
    }

    private void aplicarEstiloDescarcar() {
        setBackground(BG_PADRAO);
        setText("");
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_DEXPLODIR);
        setText("✹");
        
    }

//    EVENTOS DO MOUSE LISTENNER


    public BotaoCampo() {
        super();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            this.campo.abrir();
        } else {
            this.campo.alternarMarcacao();
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
