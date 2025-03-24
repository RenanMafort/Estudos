package br.com.devdojo.varargs.estaticos;

public class Carro {
    private String name;
    public static int velocidadeLimite = 250;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getVelocidadeLimite() {
        return velocidadeLimite;
    }

    public static void setVelocidadeLimite(int velocidadeLimite) {
        Carro.velocidadeLimite = velocidadeLimite;
    }
}
