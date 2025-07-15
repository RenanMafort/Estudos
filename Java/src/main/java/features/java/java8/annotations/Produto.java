package features.java.java8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Voltagens.class)
@interface Voltagem {
    String tensao();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Voltagens{
    Voltagem[] value();
}

@Voltagem(tensao = "110")
@Voltagem(tensao = "220")
public class Produto {
    private String nome;
    private String sobreNome;
    private int idade;

    public Produto() {
    }

    public Produto(String nome, String sobreNome, int idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }


    public void imprime(String name1,String name2){
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
