package br.com.devdojo.varargs.generics;

import br.com.devdojo.varargs.generics.dominio.Barco;
import br.com.devdojo.varargs.generics.dominio.Carro;
import br.com.devdojo.varargs.generics.service.RentalServices;

import java.util.ArrayList;
import java.util.List;

public class RentalServicesTest {
    public static void main(String[] args) {
        List<Barco> barcoDisponiveis = new ArrayList<>(
                List.of(new Barco("LANCHA"),new Barco("CANOA")));

        List<Carro> carrosDisponiveis = new ArrayList<>(
                List.of(new Carro("BMW"),new Carro("MERCEDEZ-BENS")));

        RentalServices<Carro> rentalServices = new RentalServices<>(carrosDisponiveis);
        Carro carro = rentalServices.buscarObjetoDisponivel();
        rentalServices.retornarCarroAlugado(carro);

        RentalServices<Barco> rentalServices2 = new RentalServices<>(barcoDisponiveis);
        Barco barco = rentalServices2.buscarObjetoDisponivel();
        rentalServices2.retornarCarroAlugado(barco);
    }
}
