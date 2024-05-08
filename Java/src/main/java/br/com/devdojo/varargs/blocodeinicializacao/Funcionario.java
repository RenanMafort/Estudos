package br.com.devdojo.varargs.blocodeinicializacao;

public class Funcionario extends Pessoa{
    private double salario;

    static {
        System.out.println("Dentro do bloco statico do funcionario");
    }

    {
        System.out.println("Dentro do bloco do funcionario1");
    }
    {
        System.out.println("Dentro do bloco do funcionario2");
    }
    public Funcionario(String nome, int cpf) {
        super(nome, cpf);
        System.out.println("Dentro do construtor do Funcionario");
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
