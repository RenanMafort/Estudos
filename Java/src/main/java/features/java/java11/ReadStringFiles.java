package features.java.java11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadStringFiles {

    public static void main(String[] args) throws IOException {

        Files.writeString(Path.of("teste"),"Renan mafort sereia");
        String s = Files.readString(Path.of("teste"), StandardCharsets.ISO_8859_1);

        System.out.println(s);


    }
}
