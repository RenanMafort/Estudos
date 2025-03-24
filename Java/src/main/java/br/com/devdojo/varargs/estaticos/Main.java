package br.com.devdojo.varargs.estaticos;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.setName("tette");
        Carro.setVelocidadeLimite(200);
    }
}
