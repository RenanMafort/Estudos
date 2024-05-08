package br.com.devdojo.varargs.enums;

public enum TipoEnum {

    PESSOA_JURIDICA(1,"Pessoa Juridica"),
    PESSOA_FISICA(2,"Pessoa Fisica");

    private final int codigo;
    private final String nome;

    TipoEnum(int codigo,String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    public static TipoEnum tipoClientePorNomeRelatorio(String nomeRelatorio){
        for (TipoEnum tipoCliente : values()) {
            if (tipoCliente.getNome().equals(nomeRelatorio)){
                return tipoCliente;
            }
        }
        return null;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
