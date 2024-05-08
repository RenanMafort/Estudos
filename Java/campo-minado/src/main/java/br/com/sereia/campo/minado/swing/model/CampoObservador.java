package br.com.sereia.campo.minado.swing.model;

public interface CampoObservador {

    void eventoOcorreu(Campo campo, CampoEvento evento);
}
