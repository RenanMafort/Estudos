package br.com.devdojo.varargs.enums;

public class Cliente {
    private String nome;
    public TipoEnum tipoEnum;
    public TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoEnum tipoEnum) {
        this.nome = nome;
        this.tipoEnum = tipoEnum;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoEnum=" + tipoEnum.getCodigo() + tipoEnum.getNome() +
                '}';
    }
}
