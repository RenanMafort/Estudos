package br.com.sereia.renan.padroes.projeto.observer;

public class Namorada implements ObservadorChegadaAniversariante{
    @Override
    public void chegou(EventoChegadaAniversariante evento) {
        System.out.println("Avisar os convidados");
        System.out.println("Apagar as Luzes");
        System.out.println("Surpresa...!");
    }
}
