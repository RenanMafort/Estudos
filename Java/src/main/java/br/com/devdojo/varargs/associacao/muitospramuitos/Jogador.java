package br.com.devdojo.varargs.associacao.muitospramuitos;

import java.util.List;

public class Jogador {
    private String nome;

    private List<Time> time;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void imprime(){


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }
}
