package br.com.devdojo.varargs.zipemstream;

import org.apache.wink.common.internal.providers.entity.csv.CsvWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTeste {
    public static String[] gerarCabecalhoArray() {
        List<String> fullHeader = new ArrayList<>();
        fullHeader.add("diretoria_regional");
        fullHeader.add(";");
        fullHeader.add("gerencia_regional");
        fullHeader.add(";");


        // O true é só pra teste
        if (true) {
            fullHeader.add("grupo");
            fullHeader.add(";");
        }


        return fullHeader.toArray(new String[0]);
    }

    public static String[] adicionarLinha() {
        List<String> addLinhas = new ArrayList<>();
        addLinhas.add("PARANA");
        addLinhas.add(";");
        addLinhas.add("ROLANDIA");
        addLinhas.add(";");

        if (true) {
            addLinhas.add("43");
            addLinhas.add(";");
        }



        return addLinhas.toArray(new String[0]);
    }

    public static byte[] createZip(byte[] csvData) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zipOut = new ZipOutputStream(baos)) {
            // Adicione o arquivo CSV ao ZIP
            ZipEntry entry = new ZipEntry("dados.csv");
            zipOut.putNextEntry(entry);
            zipOut.write(csvData);
            zipOut.closeEntry();

            ZipEntry entry2 = new ZipEntry("dados2.csv");
            zipOut.putNextEntry(entry2);
            zipOut.write(csvData);
            zipOut.closeEntry();
        }

        return baos.toByteArray();
    }

    public static void saveBytesToFile(byte[] data, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
        }
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(CsvWriter.getCSVRow(gerarCabecalhoArray()).getBytes());
        byteArrayOutputStream.write("\n".getBytes());
        byteArrayOutputStream.write(CsvWriter.getCSVRow(adicionarLinha()).getBytes());

        byte[] zipBytes = createZip(byteArrayOutputStream.toByteArray());

        // Converter os bytes do ZIP em uma string
        Base64.getEncoder().encode(zipBytes);

        saveBytesToFile(zipBytes,"C:\\Users\\Renan\\Desktop\\asd.zip");


    }
}
