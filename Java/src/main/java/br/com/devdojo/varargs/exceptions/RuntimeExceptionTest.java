package br.com.devdojo.varargs.exceptions;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            divisao(1,0);
        }catch (RuntimeException e ){
            e.printStackTrace();
        }
        System.out.println("Finalizado");
    }

    private static int divisao(int a, int b){
        if (b==0){
            throw new IllegalArgumentException("Argumento inválido");
        }
        return  a/b;
    }
}
