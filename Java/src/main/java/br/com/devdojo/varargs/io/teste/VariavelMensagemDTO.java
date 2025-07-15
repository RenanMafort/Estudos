package br.com.devdojo.varargs.io.teste;

public class VariavelMensagemDTO {
    private String chave;       // variávelMensagem (ex: "ANO_MES_REFERENCIA")
    private String label;       // descrição ou label amigável
    private Object valor;
    private String tipoPerfil;  // para controle de visibilidade

    // construtores, getters e setters
    public VariavelMensagemDTO(String chave, String label, Object valor, String tipoPerfil) {
        this.chave = chave;
        this.label = label;
        this.valor = valor;
        this.tipoPerfil = tipoPerfil;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
}
