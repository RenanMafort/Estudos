package pt.com.teste;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GeradorMensagemServiceNew {

    private final TemplateService templateService = new TemplateService();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String gerarMensagem(DadosMensagemDTO dto) {
        List<String> mensagens = new ArrayList<>();
        String data = formatarData(dto.getDataPagamento());
        String valor = formatarValor(dto.getValorReceber());
        boolean deducao = possuiDeducao(dto);

        if (isPago(dto)) {
            if (isDataFutura(dto.getDataPagamento())) {
                mensagens.add(mensagemPrevista(dto, data, valor));
            } else {
                mensagens.add(mensagemPagoBase(dto, data, valor));
                mensagens.addAll(mensagensComplementares(dto, data, valor, deducao));
            }
        } else if ("Não".equalsIgnoreCase(dto.getEstado())) {
            mensagens.add(mensagemNaoPago(dto, data, valor));
        } else if ("Aguarda Confirmação".equalsIgnoreCase(dto.getEstado())) {
            mensagens.add(mensagemAguardandoConfirmacao(dto, data, valor));
        }

        return String.join("<br/>", mensagens);
    }

    private boolean isPago(DadosMensagemDTO dto) {
        return "PAGO".equalsIgnoreCase(dto.getEstado()) || "REEMITIDO".contains(dto.getEstado());
    }

    private boolean isDataFutura(Date dataPagamento) {
        return dataPagamento.after(new Date());
    }

    private boolean possuiDeducao(DadosMensagemDTO dto) {
        return dto.getDebitosMovimentos() != null && !dto.getDebitosMovimentos().isEmpty();
    }

    private String mensagemPrevista(DadosMensagemDTO dto, String data, String valor) {
        return templateService.formatar("mensagem.previsto", data, valor, dto.getTipoRecebimento(), dto.getModoPagamento());
    }

    private String mensagemPagoBase(DadosMensagemDTO dto, String data, String valor) {
        return templateService.formatar("mensagem.pago.total.sem.deducao", data, valor, dto.getTipoRecebimento(), dto.getModoPagamento());
    }

    private List<String> mensagensComplementares(DadosMensagemDTO dto, String data, String valor, boolean deducao) {
        List<String> complementares = new ArrayList<>();

        if (dto.isReemissao()) {
            if (dto.isParcial()) {
                complementares.add(templateService.formatar("mensagem.parcial.reemissao", formatarValor(dto.getValorReceber()), data));
            } else {
                complementares.add(templateService.formatar("mensagem.pago.total.reemissao", data));
            }
        }

        if (dto.isRestituido()) {
            if (dto.isParcial()) {
                complementares.add(templateService.formatar("mensagem.parcial.reembolso", formatarValor(dto.getValorReceber()), data));
            } else {
                complementares.add(templateService.formatar("mensagem.pago.total.reembolso", data));
            }
        }

        if (dto.isPenhora()) {
            if (deducao) {
                complementares.add(templateService.formatar("mensagem.penhora.deducao", valor, dto.getTipoRecebimento(),
                        dto.getModoPagamento(), formatarValor(dto.getValorReceber()), "teste"));
            } else {
                complementares.add(templateService.formatar("mensagem.penhora", data, valor, dto.getTipoRecebimento(), dto.getModoPagamento(), "teste"));
            }
        } else if (deducao) {
            complementares.add(templateService.formatar("mensagem.deducao", formatarValor(dto.getValorDescontar())));
        }

        return complementares;
    }

    private String mensagemNaoPago(DadosMensagemDTO dto, String data, String valor) {
        return templateService.formatar("mensagem.nao.pago", data, valor, dto.getTipoRecebimento(), dto.getModoPagamento(), dto.getMotivo());
    }

    private String mensagemAguardandoConfirmacao(DadosMensagemDTO dto, String data, String valor) {
        return templateService.formatar("mensagem.aguarda.confirmacao", data, valor, dto.getTipoRecebimento(), dto.getModoPagamento());
    }

    private String formatarData(Date data) {
        return data != null ? formatter.format(data.toInstant().atZone(ZoneId.systemDefault())) : "-";
    }

    private String formatarValor(BigDecimal valor) {
        return String.format(Locale.forLanguageTag("pt-PT"), "%,.2f€", valor);
    }
}
