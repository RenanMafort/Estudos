package br.com.devdojo.varargs.comportamento.dominio;

public class Car {
    private String nome = "Audi";
    private String color;
    private int year;

    public Car( String color, int year) {
        this.color = color;
        this.year = year;
    }

    public String getNome() {
        return nome;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nome='" + nome + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
