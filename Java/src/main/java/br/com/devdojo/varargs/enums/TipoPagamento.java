package br.com.devdojo.varargs.enums;

public enum TipoPagamento {
    DEBITO{
        public double calcularDesconto(double valor) {
            return valor  * 0.1;
        }
    } ,

    CREDITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.05;
        }
    };

    public abstract double calcularDesconto(double valor);
}
