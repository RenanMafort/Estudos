package br.com.devdojo.varargs.exceptions;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.DivisaoPorZeroException;

public class Testando {

    private static int divisao(int num, int num2) throws DivisaoPorZeroException {
        if (num2 == 0) throw new DivisaoPorZeroException();
        return num / num2;
    }

    public static void main(String[] args) {
        System.out.println(divisao(2,0));
    }
}
