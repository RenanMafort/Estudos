package features.java.java20;

import java.lang.ScopedValue;

/**
 * @author Renan Sereia
 * @date 20/11/2025
 */
public class ScopedValueEx {
    private static final ScopedValue<String> NOME = ScopedValue.newInstance();

    public static void main(String[] args) {
        ScopedValue.where(NOME,"TESTE 123").run(ScopedValueEx::imprimeSaudacao);
    }

    private static void imprimeNome(String nome){
        System.out.print("Eu sou " + nome);
    }

    private static void imprimeOla(){
        System.out.print("Olá! ");
        imprimeNome(NOME.get());
    }

    private static void imprimeSaudacao(){
        imprimeOla();
    }
}
