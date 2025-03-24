package br.com.devdojo.varargs.enums;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Renan",TipoEnum.PESSOA_FISICA);
        Cliente cliente2 = new Cliente("Renan",TipoEnum.PESSOA_FISICA);
        Cliente cliente3 = new Cliente("Renan",TipoEnum.PESSOA_FISICA);

//        TipoEnum tipoEnum = TipoEnum.tipoClientePorNomeRelatorio("Pessoa Juridica");
//        System.out.println(tipoEnum);
//        System.out.println(cliente.toString());
//
//
//        System.out.println(TipoPagamento.CREDITO.calcularDesconto(222));
//        System.out.println(TipoPagamento.DEBITO.calcularDesconto(222));
//        TipoEnum tipoCliente = TipoEnum.valueOf("PESSOA_JURIDICA");
//        System.out.println(tipoCliente);


        System.out.println(TipoPagamento.DEBITO.calcularDesconto(200));
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(2));

        System.out.println(TipoEnum.PESSOA_JURIDICA.getNome().length());
        System.out.println(Arrays.toString(TipoEnum.values()));
    }
}
