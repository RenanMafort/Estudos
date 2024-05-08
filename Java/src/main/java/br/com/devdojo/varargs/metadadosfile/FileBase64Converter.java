package br.com.devdojo.varargs.metadadosfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FileBase64Converter {

    public static String fileToBase64(String path) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        return Base64.getEncoder().encodeToString(fileBytes);
    }

    public static void base64ToFile(String base64String, String outputPath) throws IOException {
        byte[] fileBytes = Base64.getDecoder().decode(base64String);
        Files.write(Paths.get(outputPath),fileBytes);
    }

    public static void main(String[] args) {
        String filePath = "D:\\Meus_Itens\\ProtocoloAgendamento.pdf";
        try {
            String toBase64 = FileBase64Converter.fileToBase64(filePath);
            System.out.println(toBase64);

            String outputPath = "C:\\Users\\Renan\\Desktop\\testandofiletobase64.pdf";
            FileBase64Converter.base64ToFile(toBase64,outputPath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
