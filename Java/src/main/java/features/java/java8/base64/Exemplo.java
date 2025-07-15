package features.java.java8.base64;

import java.util.Base64;

public class Exemplo {
    public static void main(String[] args) {
        String longString = "Base64 encoding is a common technique used to encode binary data as ASCII text, "
                + "which is useful for transmission over text-based protocols like email or embedding in JSON.";

        // Encoder padrão
        String encodedStandard = Base64.getEncoder().encodeToString(longString.getBytes());

        // Encoder URL-safe
        String encodedUrl = Base64.getUrlEncoder().encodeToString(longString.getBytes());

        // Encoder MIME (irá quebrar em linhas de 76 caracteres)
        String encodedMime = Base64.getMimeEncoder().encodeToString(longString.getBytes());

        System.out.println("===== Base64.getEncoder() =====");
        System.out.println(encodedStandard);
        System.out.println();

        System.out.println("===== Base64.getUrlEncoder() =====");
        System.out.println(encodedUrl);
        System.out.println();

        System.out.println("===== Base64.getMimeEncoder() =====");
        System.out.println(encodedMime);
        System.out.println();

        System.out.println("===== Base64PaddingExample  =====");
        System.out.println(Base64.getEncoder().encodeToString("ABC".getBytes())); // QUJD
        System.out.println(Base64.getEncoder().encodeToString("AB".getBytes()));  // QUI=
        System.out.println(Base64.getEncoder().encodeToString("A".getBytes()));   // QQ==
    }
}
