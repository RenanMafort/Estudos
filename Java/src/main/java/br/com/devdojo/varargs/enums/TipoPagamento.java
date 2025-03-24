package br.com.devdojo.varargs.enums;

public enum TipoPagamento {
    DEBITO{
        @Override
        public double calcularDesconto(double valor) {
            return valor;
        }
    },
    CREDITO{
        @Override
        public double calcularDesconto(double valor) {
            return valor;
        }
    };

    public abstract double calcularDesconto(double valor);
}
