package br.com.devdojo.varargs.io.teste;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class DetalheMovimentosAssociadosDTO {
    private String anoMesReferencia;
    private BigDecimal codigoEstabelecimento;
    private BigDecimal codigoServico;
    private Date dataInicioOrigem;
    private Date dataFimOrigem;
    private Date dataPagNaoPag;
    private BigDecimal niss;
    private String nomeRegistoSubSistemaOrigem;
    private BigDecimal numeroNotaReposicao;
    private BigDecimal numeroPlanoPrestacional;
    private BigDecimal numeroProcessoCo;
    private BigDecimal numeroSeqMovCc;
    private BigDecimal   valor;
    private String codigoAmbito;
    private String numeroProcesso;
    private String nome;
    private String mensagemLonga;
    private String tipoMovimentoCurto;
    private String tipoMovimentoLongo;
    private String nomeCompleto;
    private String periodo;



    private List<VariavelMensagemDTO> variaveisMensagem = new ArrayList<>();

    public List<VariavelMensagemDTO> getVariaveisMensagem() {
        return variaveisMensagem;
    }

    public void setVariaveisMensagem(List<VariavelMensagemDTO> variaveisMensagem) {
        this.variaveisMensagem = variaveisMensagem;
    }

}
