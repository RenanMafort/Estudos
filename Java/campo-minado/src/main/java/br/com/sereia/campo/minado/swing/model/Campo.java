package br.com.sereia.campo.minado.swing.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;
    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();
    private List<CampoObservador> observadors = new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void registrarObservador(CampoObservador observador){
            this.observadors.add(observador);
    }

    private void notificarObservador(CampoEvento evento){
        observadors.forEach(o -> o.eventoOcorreu(this,evento));
    }

    public boolean adicionharVizinho(Campo vizinho) {
        boolean linhaDiferente = this.linha != vizinho.linha;
        boolean colunaDiferente = this.coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(this.linha - vizinho.linha);
        int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
        int deltaGeral = deltaLinha + deltaColuna;

        if (deltaGeral == 1 && !diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else if (deltaGeral == 2 && diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }

    public void alternarMarcacao() {
        if (!aberto) {
            marcado = !marcado;

            if (this.marcado) {
                notificarObservador(CampoEvento.MARCAR);
            } else {
                notificarObservador(CampoEvento.DESMARCAR);
            }
        }
    }

    public boolean abrir() {
        if (!aberto && !marcado) {
            aberto = true;

            if (minado) {
                notificarObservador(CampoEvento.EXPLODIR);
                return true;
            }
            setAberto(true);
            if (vizinhancaSegura()) {
                vizinhos.forEach(Campo::abrir);
            }
            return true;
        }
        return false;
    }

    boolean objetivoAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = marcado && minado;
        return desvendado || protegido;
    }

    public long minasVizinhanca() {
        return vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar() {
        aberto = false;
        minado = false;
        marcado = false;
        notificarObservador(CampoEvento.REINICIAR);
    }

    public String toString(){
        if (marcado){
            return "X";
        } else if (aberto && minado) {
            return "*";
        } else if (aberto && minasVizinhanca() > 0) {
            return Long.toString(minasVizinhanca());
        } else if (aberto) {
            return " ";
        }else {
            return "?";
        }
    }

    public void minar() {
        this.minado = true;
    }

    public boolean vizinhancaSegura() {
        return vizinhos.stream().noneMatch(m -> m.minado);
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isMinado() {
        return minado;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public int getLinha() {
        return linha;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
        if (aberto){
            notificarObservador(CampoEvento.ABRIR);
        }
    }

    public int getColuna() {
        return coluna;
    }
}
