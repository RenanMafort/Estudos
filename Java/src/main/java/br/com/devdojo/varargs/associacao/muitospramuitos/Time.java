package br.com.devdojo.varargs.associacao.muitospramuitos;

import java.util.List;

public class Time {
    private String nome;

    private List<Jogador> jogadores;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
