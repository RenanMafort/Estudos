package br.com.sereia.renan.padroes.projeto.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {
    private List<ObservadorChegadaAniversariante> observadores = new ArrayList<>();

    public void registrarObservador(ObservadorChegadaAniversariante observador){
        observadores.add(observador);
    }

    public void monitorar(){
        Scanner scanner = new Scanner(System.in);
        String valor = "";
        while (!"sair".equalsIgnoreCase(valor)){
            System.out.println("Aniversariante chegou?");
            valor = scanner.nextLine();

            if ("sim".equalsIgnoreCase(valor)){
                EventoChegadaAniversariante aniversariante = new EventoChegadaAniversariante(new Date());

                observadores.forEach(o -> o.chegou(aniversariante));

            }else {
                System.out.println("Alarme falso! ");
            }
        }
    }
}
