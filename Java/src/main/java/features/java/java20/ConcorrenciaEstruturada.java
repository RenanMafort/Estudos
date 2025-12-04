package features.java.java20;

/**
 * @author Renan Sereia
 * @date 24/11/2025
 */
public class ConcorrenciaEstruturada {
    public static void main(String[] args) {
        int[][] matrizA = {{-1,2},{3,4}};
        int[][] matrizB = {{3,9},{2,7}};

        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;

        int linhasB = matrizB.length;
        int colunasB = matrizB[0].length;

        if (colunasA != linhasB){
            throw new IllegalArgumentException("As dimensoes das matrizes não sao compativeis para o calculo");
        }

        int[][] matrizR = new int[linhasA][colunasB];

        for (int l = 0; l < linhasA; l++) {
            for (int c = 0; c < colunasB; c++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    matrizR[l][c] += matrizA[l][k] * matrizB[k][c];
                }
            }
        }
        
        for (int l = 0; l < matrizR.length; l++) {
            for (int j = 0; j < matrizR[l].length; j++) {
                System.out.print(matrizR[l][j] + " ");
            }
            System.out.println();
        }
        
    }
}
