package features.java.java20;

/**
 * @author Renan Sereia
 * @date 20/11/2025
 */
public class ScopedValueOld {
    public static void main(String[] args) {
        imprimeSaudacao("Renan");
    }

    private static void imprimeNome(String nome){
        System.out.print("Eu sou " + nome);
    }

    private static void imprimeOla(String nome){
        System.out.print("Olá! ");
        imprimeNome(nome);
    }

    private static void imprimeSaudacao(String nome){
        imprimeOla(nome);
    }
}
