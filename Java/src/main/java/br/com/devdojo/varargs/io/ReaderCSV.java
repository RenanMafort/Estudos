package br.com.devdojo.varargs.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class ReaderCSV {
    public static void main(String[] args) {
        validaFileDistribuicao();
        validaFileDistribuicao32();
    }

        public static void validaFileDistribuicao() {
            Set<Integer> juncoesValidas = new HashSet<>();
            File file = new File("D:\\TESTE\\testando.csv");
            File fileOutput = new File("D:\\TESTE\\reader.csv");
            BufferedReader br = null;
            BufferedWriter bw = null;
            String linha = "";
            int linhaAtual = 0;
            int contLine = 0;
            int lineJuncao = 2;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput)));
                while ((linha = br.readLine()) != null) {
                    String[] colunas = linha.split(";");
                    if (linhaAtual == 0) {
                        bw.write(colunas[0] + ";" + colunas[1] +";"
                                + colunas[2] + ";"+  colunas[3] + ";");
                        linhaAtual++;
                        continue;
                    }else if (linhaAtual == 1) {
                        bw.newLine();
                        bw.write(colunas[0] + ";");
                        bw.newLine();
                        linhaAtual++;
                        continue;
                    }
                    if (linhaAtual == 2 && !colunas[0].trim().isEmpty()) {
                        juncoesValidas.add(Integer.parseInt(colunas[0]));
                        contLine++;
                    }
                }

                if (contLine > 10000) {
    //                FuncoesManagedBean.adicionarSimpleModalMessage(BeansConstants.MENSAGEM_QUANTIDADE_LINHAS.getValor());
                    file.delete();
                    return ;
                }

                for (Integer juncao:juncoesValidas){
                    bw.write(juncao.toString() + ";");
                    bw.newLine();
                }
                bw.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (bw != null) {
                        bw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void validaFileDistribuicao32() {
        try {
            FileInputStream fis = new FileInputStream("D:\\TESTE\\reader.csv");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String linha;
            while ((linha = br.readLine()) != null) {
                // Processar cada linha conforme necessário
                System.out.println(linha); // Exemplo de impressão da linha
            }

            br.close(); // Não se esqueça de fechar o BufferedReader
        } catch (IOException e) {
            e.printStackTrace(); // Lidar com exceções apropriadamente
        }
    }


}

