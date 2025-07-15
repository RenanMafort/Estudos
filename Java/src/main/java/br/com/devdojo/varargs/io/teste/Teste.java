package br.com.devdojo.varargs.io.teste;

import org.apache.commons.lang.WordUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws Exception {
        new Teste().popularVariaveisMensagem(DetalheMovimentosAssociadosDTO.builder()
                .anoMesReferencia("2023-05")
                .codigoEstabelecimento(new BigDecimal("987"))
                .codigoServico(new BigDecimal("555"))
                .dataInicioOrigem(new Date())
                .dataFimOrigem(new Date())
                .dataPagNaoPag(new Date())
                .niss(new BigDecimal("12345678900"))
                .nomeRegistoSubSistemaOrigem("Sistema X")
                .numeroNotaReposicao(new BigDecimal("1001"))
                .numeroPlanoPrestacional(new BigDecimal("2002"))
                .numeroProcessoCo(new BigDecimal("3003"))
                .numeroSeqMovCc(new BigDecimal("4004"))
                .valor(new BigDecimal("1500.75"))
                .codigoAmbito("AS")
                .numeroProcesso("PROC-1234")
                .nome("João Silva")
                .mensagemLonga("Mensagem longa exemplo")
                .tipoMovimentoCurto("PG")
                .tipoMovimentoLongo("Pagamento")
                .nomeCompleto("João da Silva")
                .periodo("Maio 2023")
                .build());
    }

    public void popularVariaveisMensagem(DetalheMovimentosAssociadosDTO dto) throws Exception {
        List<ConfiguracaoCamposAmbito> configs = List.of(
                ConfiguracaoCamposAmbito.builder()
                        .id(1L)
                        .tipoMovimento("PG")
                        .codigoAmbito("PF")
                        .variavelMensagem("ANO_MES_REFERENCIA")
                        .tipoPerfil("A")
                        .build(),
                ConfiguracaoCamposAmbito.builder()
                        .id(2L)
                        .tipoMovimento("PG")
                        .codigoAmbito("PF")
                        .variavelMensagem("CODIGO_SERVICO")
                        .tipoPerfil("A")
                        .build()
        );

        List<VariavelMensagemDTO> lista = new ArrayList<>();

        for (ConfiguracaoCamposAmbito config : configs) {
            String chave = config.getVariavelMensagem();
            String label = chave; // aqui você pode customizar para pegar uma descrição amigável de outra fonte, se existir
            String tipoPerfil = config.getTipoPerfil();

            Object valor = null;
            try {
                // Monta o nome do getter a partir da chave, ex: "ANO_MES_REFERENCIA" -> "getAnoMesReferencia"
                String metodo = "get" + chaveToCamelCase(chave);
                Method m = DetalheMovimentosAssociadosDTO.class.getMethod(metodo);
                valor = m.invoke(dto);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            // Adiciona só se valor não for null e tipoPerfil condiz
            if (valor != null && podeMostrar(tipoPerfil)) {
                lista.add(new VariavelMensagemDTO(chave, label, valor, tipoPerfil));
            }
        }
        dto.setVariaveisMensagem(lista);
    }

    // Helper para converter chave com underscore para camelCase
    private String chaveToCamelCase(String chave) {
        return WordUtils.capitalizeFully(chave,new char[]{'_'}).replaceAll("_","");

    }

    // Exemplo básico de controle de perfil (ajuste conforme seu caso)
    private boolean podeMostrar(String tipoPerfil) {
        // Supondo que você tenha perfil do usuário no contexto, ex:
        // String perfilUsuario = getPerfilUsuarioLogado();
        // Se tipoPerfil == 'A' mostra para todos, senão verifica
        return "A".equals(tipoPerfil) /*|| perfilUsuario.equals(tipoPerfil)*/;
    }
}
