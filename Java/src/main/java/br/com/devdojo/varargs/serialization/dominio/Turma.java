package br.com.devdojo.varargs.serialization.dominio;

import java.io.Serializable;

public class Turma  {
    private String nome;

    public Turma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
