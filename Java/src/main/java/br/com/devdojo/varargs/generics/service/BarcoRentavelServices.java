package br.com.devdojo.varargs.generics.service;

import br.com.devdojo.varargs.generics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelServices {
    private List<Barco> barcoDisponiveis = new ArrayList<>(
            List.of(new Barco("LANCHA"),new Barco("CANOA")));
    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando barco disponivel");
        Barco barco = barcoDisponiveis.remove(0);
        System.out.println("Alugando barco: " + barco);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(barcoDisponiveis);
        return barco;
    }

    public void retornarBarcosAlugado(Barco barco){
        System.out.println("Devolvendo barco " + barco);
        barcoDisponiveis.add(barco);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(barcoDisponiveis);
    }
}
