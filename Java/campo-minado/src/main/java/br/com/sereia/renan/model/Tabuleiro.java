package br.com.sereia.renan.model;

import br.com.sereia.renan.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        
        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }



    public void abrir(int linha,int coluna){
        try {
            campos.parallelStream().filter(
                    c -> c.getLinha() == linha && c.getColuna() == coluna
            ).findFirst().ifPresent(Campo::abrir);
        }catch (ExplosaoException e){
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
                campos.add(new Campo(linha,coluna));
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
        do {
            int aleatorio = (int) (Math.random() * campos.size() -1);
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();
        }while (minasArmadas < this.minas);
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

}
