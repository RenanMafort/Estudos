//public class TSTE {
//
//    public static void main(String[] args) {
//
//    }
//
//    public static String preencherHeader(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("NOME").append(";").append("SOBRENOME").append(";").append("IDADE");
//
//        return sb.toString();
//    }
//
//    public static String preencherLinhas(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("RENAN").append(";").append("SEREIA").append(";").append("24").append("\n")
//        .append("igor").append(";").append("Algusto").append(";").append("32").append("\n");
//
//        return sb.toString();
//    }
//}

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TSTE {
    public static void main(String[] args) throws IOException {
        String csvData = preencherHeader() + "\n" + preencherLinhas();
        byte[] zipBytes = createZipWithCSV(csvData, "dados.zip");

        System.out.println(Arrays.toString(zipBytes));
        String s = new String(Base64.getEncoder().encode(zipBytes));
        System.out.println(s);

        byte[] decode = Base64.getDecoder().decode(s);
        System.out.println(Arrays.toString(decode));
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));

        // Agora você pode passar 'zipBytes' em uma requisição.

        // Para testar, você pode criar o arquivo no diretório atual
//        String outputPath = "C:\\Users\\Renan\\Desktop\\dados.zip";
//        saveBytesToFile(zipBytes, outputPath);
//        System.out.println("Arquivo ZIP gerado com sucesso em: " + outputPath);
    }

    public static String preencherHeader() {
        return "NOME;SOBRENOME;IDADE";
    }

    public static String preencherLinhas() {
        return "RENAN;SEREIA;24\nigor;Algusto;32\n";
    }

    public static byte[] createZipWithCSV(String csvData, String zipFileName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zipOut = new ZipOutputStream(baos)) {
            // Adicione o arquivo CSV ao ZIP
            ZipEntry entry = new ZipEntry("dados.csv");
            zipOut.putNextEntry(entry);
            zipOut.write(csvData.getBytes());
            zipOut.closeEntry();
        }

        // Salve o arquivo ZIP no sistema de arquivos
        saveBytesToFile(baos.toByteArray(), zipFileName);

        return baos.toByteArray();
    }

    public static void saveBytesToFile(byte[] data, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
        }
    }
}

