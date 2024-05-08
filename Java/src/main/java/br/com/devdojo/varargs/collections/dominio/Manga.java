package br.com.devdojo.varargs.collections.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> {
    private long id;
    private String nome;
    private double valor;
    private int quantidade;

    public Manga(Long id, String nome, Double valor) {
        Objects.requireNonNull(id,"Id não pode ser nulo");
        Objects.requireNonNull(nome);
        Objects.requireNonNull(valor);
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    public Manga(Long id, String nome, double valor, int quantidade) {
        this(id,nome, (double) quantidade);
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return id == manga.id || nome.equalsIgnoreCase(manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public int compareTo(Manga outroManga) {
        //Negativo se o this < outroManga
        //se this == outroManga, return 0
        //positivo se this > outroManga
//        if (this.id < outroManga.getId()){
//            return -1;
//        }else if (this.id == outroManga.getId()){
//            return 0;
//        }else {
//            return 1;
//        }
//        return this.id.compareTo(outroManga.getId());//Wrappers tem o compareto
        Double value = Double.valueOf(valor); //passando primitivo para wrappers para poder utiizar o compareto

//        return  Double.valueOf(valor).compareTo(outroManga.getValor()); isso é a mesma coisa que o de baixo
        return Double.compare(value,outroManga.getValor());
    }
}
