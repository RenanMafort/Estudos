package br.com.devdojo.varargs.generics;

import br.com.devdojo.varargs.generics.dominio.Carro;
import br.com.devdojo.varargs.generics.service.CarroRentavelServices;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {

        CarroRentavelServices carroRentavelServices = new CarroRentavelServices();
        Carro carro = carroRentavelServices.buscarCarroDisponivel();
        System.out.println("Usando carro por um mês...");
        carroRentavelServices.retornarCarroAlugado(carro);
    }
}
