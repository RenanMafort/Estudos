package br.com.sereia.swing.calculadora.model;

@FunctionalInterface
public interface MemoriaObservador {

    void valorAlterado(String novoValor);
}
