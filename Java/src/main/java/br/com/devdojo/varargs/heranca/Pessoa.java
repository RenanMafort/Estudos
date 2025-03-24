package br.com.devdojo.varargs.heranca;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String endereco;

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco);
    }



    public final void imprime2(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
