package br.com.devdojo.varargs.polimorfismo.teste;

import br.com.devdojo.varargs.polimorfismo.Repositorio;

public class TesteInteface {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio() {
            @Override
            public void salvar() {
                System.out.println("Teste");
            }
        };

        Repositorio repositorio2 = () -> System.out.println("Teste salvar com lambda");
        repositorio.salvar();
        repositorio2.salvar();
    }
}
