package br.com.sereia.campo.minado.swing.model;


import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoObservador{

    private final int linhas;
    private final int colunas;
    private final int minas;

    private final List<Campo> campos = new ArrayList<>();
    private final List<Consumer<ResultadaoEvento>> observadores = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        
        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void registrarObservador(Consumer<ResultadaoEvento> consumer){
        this.observadores.add(consumer);
    }

    private void notificarObservador(boolean evento){
        observadores.forEach(o -> o.accept(new ResultadaoEvento(evento)));
    }

    public void forEach(Consumer<Campo> funcao){
        this.campos.forEach(funcao);
    }

    public void abrir(int linha,int coluna){
        try {
            campos.parallelStream().filter(
                    c -> c.getLinha() == linha && c.getColuna() == coluna
            ).findFirst().ifPresent(Campo::abrir);
        }catch (Exception e){
            //FIXME Ajustar a exceção
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }
    public void alterMarcacao(int linha,int coluna){
        campos.parallelStream().filter(
                c -> c.getLinha() == linha && c.getColuna() == coluna
        ).findFirst().ifPresent(Campo::alternarMarcacao);
    }

    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++){
            for (int coluna = 0; coluna < colunas; coluna++){
                Campo campo = new Campo(linha, coluna);
                campo.registrarObservador(this);
                campos.add(campo);
            }
        }
    }

    private void associarVizinhos() {
        for (Campo c1 : campos){
            for (Campo c2: campos){
                c1.adicionharVizinho(c2);
            }
        }
    }
    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = Campo::isMinado;
       if (campos.size() <= minas){
           campos.forEach(Campo::minar);
       }else {
           do {
               int aleatorio = (int) (Math.random() * campos.size());
               campos.get(aleatorio).minar();
               minasArmadas = campos.stream().filter(minado).count();
           }while (minasArmadas < this.minas);
       }
    }

    public boolean objetivoAlcancado(){
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }


    public void reinicar(){
        campos.forEach(Campo::reiniciar);
        sortearMinas();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("  ");
        for (int c = 0; c < colunas; c++) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }
        sb.append("\n");
        for (int l = 0; l < linhas; l++) {
            sb.append(l);
            sb.append(" ");
            for (int c = 0; c < colunas; c++) {
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void mostrarMinas(){
        this.campos
                .stream()
                .filter(Campo::isMinado)
                .filter(c -> !c.isMarcado())
                .forEach(a -> a.setAberto(true));
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        if (evento == CampoEvento.EXPLODIR){
            mostrarMinas();
            notificarObservador(false);
        } else if (objetivoAlcancado()) {
            notificarObservador(true);
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public int getMinas() {
        return minas;
    }
}
