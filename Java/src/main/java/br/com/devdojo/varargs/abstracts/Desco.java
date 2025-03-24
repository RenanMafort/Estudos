package br.com.devdojo.varargs.abstracts;

public abstract class Desco {

    private double salario;

    public Desco(double salario) {
        this.salario = salario;
    }

    public abstract void calcularImposto();
}
