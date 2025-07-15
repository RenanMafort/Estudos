package br.com.devdojo.varargs.heranca;

public class Funcionario extends Pessoa {
    private double salario;

    @Override
    public void imprime() {
        System.out.println(this.getNome() + " recebeu " + this.getSalario());
        System.out.println(salario);

//        SUPER
        System.out.println("\nSUPER\n");
        super.imprime();
        System.out.println(super.cpf);;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
