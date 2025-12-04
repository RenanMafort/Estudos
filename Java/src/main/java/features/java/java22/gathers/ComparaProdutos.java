package features.java.java22.gathers;

import java.util.function.Supplier;
import java.util.stream.Gatherer;

/**
 * @author Renan Sereia
 * @date 02/12/2025
 */
public class ComparaProdutos implements Gatherer<String,String,String> {

    private final String produto;

    public ComparaProdutos(String estado) {
        this.produto = estado;
    }

    /**
     * Função para criar o estado inicial (A).
     * Supplier é uma interface funcional c/ método get que retorna  String.
     */

    @Override
    public Supplier<String> initializer() {
        return () -> "";
    }

    /**
     * Função para processar um elemento de entrada (T)
     * atualizar o estado (A) e
     * enviar elementos processadosp/ downstream (R) - saída
     * @return
     */
    @Override
    public Integrator<String, String, String> integrator() {
        return (estado,elemento,downstream) -> {
            if (estado.isEmpty()){
                estado = elemento;
            }

            if (elemento.contains(produto)){
                downstream.push(estado);
            }
            return true;
        };

    }
}
