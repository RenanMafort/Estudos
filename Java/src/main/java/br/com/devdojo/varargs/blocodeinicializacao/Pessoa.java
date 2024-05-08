package br.com.devdojo.varargs.blocodeinicializacao;

public class Pessoa {
     String nome ;
     int cpf ;

    static {
        System.out.println("Dentro do bloco statico de pessoa");
    }

    {
        System.out.println("Dentro do bloco do pessoa1");
    }
    {
        System.out.println("Dentro do bloco do pessoa2");
    }

    public Pessoa(String nome, int cpf) {
        System.out.println("Dentro do construtor de Pessoa");
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
