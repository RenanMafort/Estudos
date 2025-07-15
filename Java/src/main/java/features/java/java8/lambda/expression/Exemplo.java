package features.java.java8.lambda.expression;

interface Figura {
    void desenhar();
}
interface FiguraParam {
    void paramDesenhar(String param,String param2);
}

public class Exemplo {
    public static void main(String[] args) {
        Figura figura = new Figura() {
            @Override
            public void desenhar() {
                System.out.println("New Figura()");
            }
        };

        figura.desenhar();

        FiguraParam f1Param = new FiguraParam() {
            @Override
            public void paramDesenhar(String param, String param2) {
                System.out.println("New Figura() param - " + param + param2);
            }
        };

        f1Param.paramDesenhar("Teste", "Teste2");
        Figura f2 = () -> System.out.println("figura2 com lambda");
        f2.desenhar();

        FiguraParam f2Param = (p1,p2) -> System.out.println(p1 + p2);
        f2Param.paramDesenhar("Renan","Mafort");
    }



}
