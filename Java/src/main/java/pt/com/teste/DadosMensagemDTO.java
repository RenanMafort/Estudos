package pt.com.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DadosMensagemDTO {
    private String estado;
    private BigDecimal valorReceber;
    private BigDecimal valorDescontar;
    private BigDecimal valorTotal;
    private Date dataPagamento;
    private String tipoRecebimento;
    private long numeroMeioPagamento;
    private String motivo;
    private String modoPagamento;
    private String numeroIban;
    private String numeroBic;
    private boolean reemissao;
    private boolean restituido;
    private boolean penhora;
    private boolean parcial;
    private List<Long> creditosPgSemDeducao;
    private List<Long> debitosMovimentos;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(BigDecimal valorReceber) {
        this.valorReceber = valorReceber;
    }

    public BigDecimal getValorDescontar() {
        return valorDescontar;
    }

    public void setValorDescontar(BigDecimal valorDescontar) {
        this.valorDescontar = valorDescontar;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }

    public long getNumeroMeioPagamento() {
        return numeroMeioPagamento;
    }

    public void setNumeroMeioPagamento(long numeroMeioPagamento) {
        this.numeroMeioPagamento = numeroMeioPagamento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public String getNumeroIban() {
        return numeroIban;
    }

    public void setNumeroIban(String numeroIban) {
        this.numeroIban = numeroIban;
    }

    public String getNumeroBic() {
        return numeroBic;
    }

    public void setNumeroBic(String numeroBic) {
        this.numeroBic = numeroBic;
    }

    public boolean isReemissao() {
        return reemissao;
    }

    public void setReemissao(boolean reemissao) {
        this.reemissao = reemissao;
    }

    public boolean isRestituido() {
        return restituido;
    }

    public void setRestituido(boolean restituido) {
        this.restituido = restituido;
    }

    public boolean isPenhora() {
        return penhora;
    }

    public void setPenhora(boolean penhora) {
        this.penhora = penhora;
    }

    public boolean isParcial() {
        return parcial;
    }

    public void setParcial(boolean parcial) {
        this.parcial = parcial;
    }

    public List<Long> getCreditosPgSemDeducao() {
        return creditosPgSemDeducao;
    }

    public void setCreditosPgSemDeducao(List<Long> creditosPgSemDeducao) {
        this.creditosPgSemDeducao = creditosPgSemDeducao;
    }

    public List<Long> getDebitosMovimentos() {
        return debitosMovimentos;
    }

    public void setDebitosMovimentos(List<Long> debitosMovimentos) {
        this.debitosMovimentos = debitosMovimentos;
    }
}
