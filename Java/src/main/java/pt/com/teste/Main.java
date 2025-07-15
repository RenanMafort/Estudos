package pt.com.teste;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,-2);
        DadosMensagemDTO dto = new DadosMensagemDTO();
        dto.setEstado("Não");
        dto.setValorReceber(new BigDecimal("200.22"));
        dto.setValorDescontar(new BigDecimal("124.00"));
        dto.setValorTotal(new BigDecimal("76.22"));
        dto.setTipoRecebimento("Prestações Familiares");
        dto.setNumeroMeioPagamento(141202L);
        dto.setModoPagamento("PAGAMENTO BANCARIO");
        dto.setNumeroIban("1240129410PT");
        dto.setNumeroBic("12401240");
        dto.setDataPagamento(calendar.getTime());
        dto.setReemissao(true);
        GeradorMensagemService geradorMensagemService = new GeradorMensagemService();
        String s = geradorMensagemService.gerarMensagem(dto);

        System.out.println(s);
    }
}
