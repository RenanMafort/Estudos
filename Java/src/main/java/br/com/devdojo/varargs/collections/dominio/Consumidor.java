package br.com.devdojo.varargs.collections.dominio;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor implements Comparable<Consumidor> {
    private Long id;
    private String nome;

    public Consumidor( String nome) {
        this.id = ThreadLocalRandom.current().nextLong(0,100_000);
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumidor that = (Consumidor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(Consumidor o) {
        return o.getId() < this.id ? -1 : ((o.getId().equals(this.id)) ? 0 : 1);
    }
}
