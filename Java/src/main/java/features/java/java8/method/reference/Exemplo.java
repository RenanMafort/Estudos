package features.java.java8.method.reference;

import com.google.common.base.Supplier;

import java.util.function.BiConsumer;

interface Figura {
    void desenhar(Double largura, Double altura);
}
class Retangulo {
    void paramDesenhar(Double largura, Double altura){
        System.out.println("Retangulo de largura - " + largura + " e altura - " + altura);
    };
}

public class Exemplo {
    public static void main(String[] args) {
        Figura figura = (l,a) ->  System.out.println("Figura de largura - " + l + " e altura - " + a);
        figura.desenhar(2.6, 2.8);

        Retangulo retangulo = new Retangulo();
        Figura paramDesenhar = retangulo::paramDesenhar;

        paramDesenhar.desenhar(22.5,13.8);

//        Figura aNew = Retangulo::new;

    }



}
