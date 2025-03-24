package features.java.java12;

public class StringEx {

    public static void main(String[] args) {
        String texto = "Olá, Mundo!\nOla, mundo novamente!";

        //Adiciona o numero de espaços no começo da linha
        texto = texto.indent(3);

        //remove espaçoes em brancos no começo da linha
        texto = texto.indent(-1);
        System.out.println(texto);


        String texto2 = "Olá, Mundo!";

        String transform = texto2.transform(s -> new StringBuilder(s).reverse().toString());
        System.out.println(transform);
    }
}
