package br.com.devdojo.varargs.generics.service;

import br.com.devdojo.varargs.generics.dominio.Barco;
import br.com.devdojo.varargs.generics.dominio.Carro;

import java.util.List;

public class RentalServices<T> {
    private List<T> disponiveis ;
    public RentalServices(List<T> disponiveis){
        this.disponiveis = disponiveis;
    }

    public T buscarObjetoDisponivel(){
        System.out.println("Buscando objeto disponivel");
        T objeto =  disponiveis.remove(0);
        System.out.println("Alugando objeto: " + objeto);
        System.out.println("objetos disponiveis para alugar: ");
        System.out.println(disponiveis);
        return objeto;
    }

    public void retornarCarroAlugado(T objeto){
        System.out.println("Devolvendo objeto " + objeto);
        disponiveis.add(objeto);
        System.out.println("objeto disponiveis para alugar: ");
        System.out.println(disponiveis);
    }
}
