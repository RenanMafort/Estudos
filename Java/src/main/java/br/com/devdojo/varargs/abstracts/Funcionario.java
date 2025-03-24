package br.com.devdojo.varargs.abstracts;

public class Funcionario extends Desco{

    private double salario;

    public Funcionario(double salario) {
        super(salario);
        this.salario = salario;
        calcularImposto();
    }

    public double getSalario() {
        return salario;
    }

    public void calcularImposto(){
        this.salario = salario + salario *0.1;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                '}';
    }
}
