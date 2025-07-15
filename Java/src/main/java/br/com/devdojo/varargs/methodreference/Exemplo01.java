package br.com.devdojo.varargs.methodreference;

import com.sun.istack.NotNull;

@FunctionalInterface
interface Figura2d{
    void imprimeFigura(Double largura, Double altura);

}
@FunctionalInterface
interface Figura3d{

    ImprimindoValurWithConstructor imprime(int valueOne, int valueTwo);
}

class Retangulo {
    public void imprimeFiguraRetangulo(Double largura, Double altura){
        System.out.printf("Retanguloo :- Largura : %s | Altura: %s",largura,altura);
    }
}

class ImprimindoValurWithConstructor{
    public ImprimindoValurWithConstructor(int valueOne, int valurTwo) {
        System.out.printf("ALOOOOOOOOOOOOOOOO %s - %s",valueOne,valurTwo);
    }
}

public class Exemplo01 {

    public static void main(String[] args) {

        Figura2d f2 = (x,y) -> System.out.printf("Largura : %s | Altura: %s",x,y);
        f2.imprimeFigura(2.0,3.0);

        Retangulo r = new Retangulo();
        Figura2d f1 = r::imprimeFiguraRetangulo;

        System.out.println();
        f1.imprimeFigura(2.0,3.0);

        System.out.println();
        Figura3d f3 = ImprimindoValurWithConstructor::new;
        f3.imprime(4,5);

    }
}
