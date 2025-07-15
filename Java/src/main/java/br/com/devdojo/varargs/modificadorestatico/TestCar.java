package br.com.devdojo.varargs.modificadorestatico;

public class TestCar {

    public static void main(String[] args) {
        Carro carro = new Carro("ABC");
        System.out.println(Carro.marca);
    }
}
