package br.com.devdojo.varargs.polimorfismo.servico;

import br.com.devdojo.varargs.polimorfismo.dominio.Computador;
import br.com.devdojo.varargs.polimorfismo.dominio.Produto;
import br.com.devdojo.varargs.polimorfismo.dominio.Tomate;

import java.util.LinkedList;
import java.util.List;

public class CalcularImposto {

    public static void calcularImposto(Produto produto){

        List<String> list = new LinkedList<>();
        list.add("1");

        System.out.println("Relátorio de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Imposto do computador " + produto.getNome());
        System.out.println("Valor " + produto.getValor());
        System.out.println("Imposto a ser pago " + imposto);

        if (produto instanceof Tomate){
            Tomate tomate = (Tomate) produto;
        }
//        Tomate tomate = (Tomate) produto;
    }
}
