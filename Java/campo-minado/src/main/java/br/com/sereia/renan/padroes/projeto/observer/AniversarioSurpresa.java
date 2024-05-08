package br.com.sereia.renan.padroes.projeto.observer;

public class AniversarioSurpresa {
    public static void main(String[] args) {
        Namorada namorada = new Namorada();
        Porteiro porteiro = new Porteiro();
        porteiro.registrarObservador(namorada);
        porteiro.registrarObservador(e -> System.out.println("chegouu"));

        porteiro.monitorar();
    }
}
