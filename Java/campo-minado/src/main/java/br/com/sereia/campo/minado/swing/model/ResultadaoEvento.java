package br.com.sereia.campo.minado.swing.model;

public class ResultadaoEvento {
    private final boolean ganhou;

    public ResultadaoEvento(boolean ganhou) {
        this.ganhou = ganhou;
    }

    public boolean isGanhou() {
        return ganhou;
    }
}
