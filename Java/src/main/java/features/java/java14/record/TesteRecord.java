package features.java.java14.record;

/**
 * @author Renan Sereia
 * @date 08/07/2025
 */
public record TesteRecord(int largura, int altura) {

    public int imprime(){
        return this.altura * this.altura;
    }

    public static void main(String[] args) {
        TesteRecord r = new TesteRecord(22,11);

        System.out.println(r);
        System.out.println(r.imprime());
    }

}

