package br.com.devdojo.varargs.generics;

import br.com.devdojo.varargs.generics.dominio.Barco;
import br.com.devdojo.varargs.generics.dominio.Carro;
import br.com.devdojo.varargs.generics.service.BarcoRentavelServices;
import br.com.devdojo.varargs.generics.service.CarroRentavelServices;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {

        BarcoRentavelServices barcoRentavelServices = new BarcoRentavelServices();
        Barco barco = barcoRentavelServices.buscarBarcoDisponivel();
        System.out.println("Usando barco por um mês...");
        barcoRentavelServices.retornarBarcosAlugado(barco);
    }
}
