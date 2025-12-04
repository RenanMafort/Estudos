package features.java.java22;

/**
 * @author Renan Sereia
 * @date 28/11/2025
 */

abstract class Figura2D {
    private int lados;
    private int comprimento;

    public Figura2D(int lados, int comprimento) {
        this.lados = lados;
        this.comprimento = comprimento;
    }
}

class Quadrado extends Figura2D {

    public Quadrado(int lados, int comprimento) {
        //não era possível executar qualqueur coisa antes do 'super'
        if (lados == 0){
            System.out.println("teste");
        }

        super(lados, comprimento);
    }
}

public class SuperEx {

    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(0, 3);

    }
}
