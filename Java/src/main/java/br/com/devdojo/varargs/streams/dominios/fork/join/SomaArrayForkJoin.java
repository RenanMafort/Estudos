package br.com.devdojo.varargs.streams.dominios.fork.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SomaArrayForkJoin {
    static class SomaTask extends RecursiveTask<Integer>{
        private final int[] array;
        private final int inicio;
        private final int fim;
        private static final int LIMIAR = 10; // Tamanho mínimo para dividir

        public SomaTask(int[] array, int inicio, int fim) {
            this.array = array;
            this.inicio = inicio;
            this.fim = fim;
        }


        @Override
        protected Integer compute() {
            int tamanho = fim - inicio;
            if (tamanho <= LIMIAR){
                int soma = 0;
                for (int i = inicio; i < fim; i++){
                    soma += array[i];
                }
                return soma;
            }
            // Divide em duas subtarefas
            int meio = inicio + tamanho / 2;
            SomaTask esquerda = new SomaTask(array, inicio, meio);
            SomaTask direita = new SomaTask(array, meio, fim);

            // Executa subtarefas de forma paralela
            esquerda.fork(); // Inicia a tarefa da esquerda em paralelo
            int direitaResultado = direita.compute(); // Computa a direita diretamente
            int esquerdaResultado = esquerda.join(); // Espera o resultado da esquerda

            return esquerdaResultado + direitaResultado;

        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Preenche o array com valores de 1 a 100
        }

        ForkJoinPool pool = new ForkJoinPool(); // Cria o pool
        SomaTask tarefa = new SomaTask(array, 0, array.length); // Cria a tarefa

        int resultado = pool.invoke(tarefa); // Inicia o processamento
        System.out.println("Soma total: " + resultado); // Deve dar 5050

        System.gc();
    }
}
