package br.com.devdojo.varargs.polimorfismo.teste;

import br.com.devdojo.varargs.polimorfismo.dominio.Computador;
import br.com.devdojo.varargs.polimorfismo.dominio.Tomate;
import br.com.devdojo.varargs.polimorfismo.servico.CalcularImposto;

public class Main {
    public static void main(String[] args) {
        Computador computador = new Computador("NUC10I7",11000);
        Tomate tomate = new Tomate("Tomate",5.03);

        CalcularImposto.calcularImposto(computador);
        System.out.println();
        CalcularImposto.calcularImposto(tomate);
    }
}
