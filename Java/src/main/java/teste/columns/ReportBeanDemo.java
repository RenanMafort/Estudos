package teste.columns;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Renan Sereia
 * @date 06/10/2025
 */
import java.util.*;
import java.util.stream.Collectors;

public class ReportBeanDemo {

    // === Bean “standalone” ===
    public static class ReportBean {
        // suas linhas (como viria do DAO)
        private List<Map<String, Object>> rows;

        // POSICAO_LAYOUT: 'C' (coluna) | 'D' (detalhe/rowExpansion)
        public enum Posicao { C, D }

        public static class ColMeta {
            private String variavelMensagem; // ex.: "MCC.DESCRICAO_CURTA" ou "NOME"
            private String field;            // ex.: "DESCRICAO_CURTA" ou "NOME"
            private String label;            // LABEL
            private boolean visivel;         // VISIVEL == 'S'
            private int ordem;               // número extraído de "ORDEM" (ex.: "3S" -> 3)
            private Posicao posicao;         // C ou D

            public ColMeta(String variavelMensagem, String label, String ordemRaw, String visivelSN, String posicaoCD) {
                this.variavelMensagem = variavelMensagem;
                this.field = extrairField(variavelMensagem);
                this.label = label;
                this.ordem = extrairNumero(ordemRaw);      // "3S" -> 3
                this.visivel = "S".equalsIgnoreCase(visivelSN);
                this.posicao = "C".equalsIgnoreCase(posicaoCD) ? Posicao.C : Posicao.D;
            }

            private static int extrairNumero(String s) {
                if (s == null) return 0;
                String digits = s.replaceAll("\\D+", "");
                return digits.isEmpty() ? 0 : Integer.parseInt(digits);
            }

            private static String extrairField(String varMsg) {
                // se vier "ALIAS.COLUNA" pega só o nome da coluna; se vier "NOME" mantém
                if (varMsg == null) return null;
                int i = varMsg.lastIndexOf('.');
                return (i >= 0 ? varMsg.substring(i + 1) : varMsg).trim();
            }

            public String getField() { return field; }
            public String getLabel() { return label; }
            public boolean isVisivel() { return visivel; }
            public int getOrdem() { return ordem; }
            public Posicao getPosicao() { return posicao; }

            @Override
            public String toString() {
                return "ColMeta{" +
                        "field='" + field + '\'' +
                        ", label='" + label + '\'' +
                        ", visivel=" + visivel +
                        ", ordem=" + ordem +
                        ", posicao=" + posicao +
                        '}';
            }
        }

        private List<ColMeta> colsHeader; // POSICAO_LAYOUT = 'C'
        private List<ColMeta> colsDetail; // POSICAO_LAYOUT = 'D'

        public void init() {
            // ==== MOCK: metadados como na sua imagem ====
            List<ColMeta> all = new ArrayList<>();
            all.add(new ColMeta("MCC.DESCRICAO_CURTA",       "Descrição curta",         "3S", "S", "C"));
            all.add(new ColMeta("MCC.VALOR",                 "Valor",                   "5S", "S", "C"));
            all.add(new ColMeta("MCC.ANO_MES_REFERENCIA",    "Periodo",                 "1S", "S", "C"));
            all.add(new ColMeta("MCC.CODIGO_SERVICO",        "Codigo de Serviço",       "2S", "S", "C"));
            all.add(new ColMeta("MCC.CODIGO_ESTABELECIMENTO","Codigo do Estabelecimento","4N","N","C")); // invisível
            all.add(new ColMeta("MCC.TIPO_MOVIMENTO",        "Tipo de Movimento",       "1S", "S", "D"));
            all.add(new ColMeta("MCC.DESCRICAO_AMBITO",      "Ambito",                  "1S", "S", "D"));
            all.add(new ColMeta("MCC.DESCRICAO_BENEFICIO",   "Beneficio",               "2S", "S", "D"));
            all.add(new ColMeta("MCC.DESCRICAO_TIPO_BENEFICIO","Tipo de Beneficio",    "3S", "S", "D"));
            all.add(new ColMeta("NOME",                      "Nome",                    "3S", "S", "D"));
            all.add(new ColMeta("NISS",                      "NISS",                    "3N", "S", "C"));
            all.add(new ColMeta("NISS",                      "NISS",                    "3N", "F", "D")); // não visível (F != S)
            // ============================================

            // filtra e separa por POSICAO + ordena por ORDEM
            colsHeader = all.stream()
                    .filter(c -> c.getPosicao() == Posicao.C && c.isVisivel())
                    .sorted(Comparator.comparingInt(ColMeta::getOrdem))
                    .collect(Collectors.toList());

            colsDetail = all.stream()
                    .filter(c -> c.getPosicao() == Posicao.D && c.isVisivel())
                    .sorted(Comparator.comparingInt(ColMeta::getOrdem))
                    .collect(Collectors.toList());

            // ==== MOCK: linhas (campos batem com "field") ====
            rows = new ArrayList<>();
            rows.add(new LinkedHashMap<>(Map.of(
                    "DESCRICAO_CURTA", "Pagamento Abril",
                    "VALOR", 7800.50,
                    "ANO_MES_REFERENCIA", "2024-04",
                    "CODIGO_SERVICO", "123",
                    "NISS", "998877",
                    "TIPO_MOVIMENTO", "PG",
                    "DESCRICAO_AMBITO", "AS",
                    "DESCRICAO_BENEFICIO", "Auxílio X",
                    "DESCRICAO_TIPO_BENEFICIO", "F",
                    "NOME", "Ana Silva"
            )));
            rows.add(new LinkedHashMap<>(Map.of(
                    "DESCRICAO_CURTA", "Pagamento Maio",
                    "VALOR", 4500.00,
                    "ANO_MES_REFERENCIA", "2024-05",
                    "CODIGO_SERVICO", "321",
                    "NISS", "112233",
                    "TIPO_MOVIMENTO", "PG",
                    "DESCRICAO_AMBITO", "AS",
                    "DESCRICAO_BENEFICIO", "Auxílio Y",
                    "DESCRICAO_TIPO_BENEFICIO", "A",
                    "NOME", "Bruno Lima"
            )));
        }

        public List<Map<String, Object>> getRows() { return rows; }
        public List<ColMeta> getColsHeader() { return colsHeader; }
        public List<ColMeta> getColsDetail() { return colsDetail; }
        public Object cell(Map<String,Object> row, String field) { return row != null ? row.get(field) : null; }
    }

    // === “Simulação de render” no console ===
    public static void main(String[] args) {
        ReportBean bean = new ReportBean();
        bean.init();

        System.out.println("== COLUNAS CABEÇALHO (C) ==");
        bean.getColsHeader().forEach(System.out::println);

        System.out.println("\n== COLUNAS DETALHE (D) ==");
        bean.getColsDetail().forEach(System.out::println);

        // Imprime um “grid” com as colunas C
        List<ReportBean.ColMeta> headers = bean.getColsHeader();
        System.out.println("\n== TABELA (C) ==");
        // cabeçalho
        for (ReportBean.ColMeta c : headers) {
            System.out.printf("%-24s", c.getLabel());
        }
        System.out.println();
        // separador
        for (int i = 0; i < headers.size(); i++) {
            System.out.printf("%-24s", "----------------------");
        }
        System.out.println();
        // linhas
        for (Map<String,Object> row : bean.getRows()) {
            for (ReportBean.ColMeta c : headers) {
                Object v = bean.cell(row, c.getField());
                System.out.printf("%-24s", v == null ? "" : v.toString());
            }
            System.out.println();
        }

        // “rowExpansion”: para cada linha, imprime pares label:valor das colunas D
        System.out.println("\n== ROW EXPANSION (D) por linha ==");
        int idx = 1;
        for (Map<String,Object> row : bean.getRows()) {
            System.out.println("-- Linha #" + (idx++) + " --");
            for (ReportBean.ColMeta d : bean.getColsDetail()) {
                Object v = bean.cell(row, d.getField());
                System.out.printf("%-24s: %s%n", d.getLabel(), v == null ? "" : v.toString());
            }
            System.out.println();
        }
    }
}
