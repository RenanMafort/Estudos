package br.com.devdojo.varargs.io.teste;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracaoCamposAmbito {
    private Long id;
    private String codigoAmbito;
    private String tipoMovimento;
    private String variavelMensagem;
    private String tipoPerfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAmbito() {
        return codigoAmbito;
    }

    public void setCodigoAmbito(String codigoAmbito) {
        this.codigoAmbito = codigoAmbito;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getVariavelMensagem() {
        return variavelMensagem;
    }

    public void setVariavelMensagem(String variavelMensagem) {
        this.variavelMensagem = variavelMensagem;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
}
