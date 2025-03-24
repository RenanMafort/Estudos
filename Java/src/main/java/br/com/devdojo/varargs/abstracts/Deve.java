package br.com.devdojo.varargs.abstracts;

public class Deve extends Desco {

    private double salario;

    public Deve(double salario) {
        super(salario);
        this.salario = salario;
        calcularImposto();
    }

    public void calcularImposto(){
        this.salario = salario + salario *0.1;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Deve{" +
                "salario=" + salario +
                '}';
    }
}
