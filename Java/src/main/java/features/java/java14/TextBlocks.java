package features.java.java14;

public class TextBlocks {

    public static void main(String[] args) {
        String texto = """
                Olá, estou escrevendo\
                em blocos\
                """;

        String html = """
                <!DOCTYPE html>\
                <html lang="en">\
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                </head>
                <body>\
                </body>\
                </html>\
                
                """;
        System.out.println(texto);
        System.out.println(html);
    }
}
