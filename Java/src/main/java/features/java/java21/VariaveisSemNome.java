package features.java.java21;

/**
 * @author Renan Sereia
 * @date 26/11/2025
 */
public class VariaveisSemNome {
    void main(){
        
        int[] nums = {1,22,3,44,5};
        
        int qtd = 0;

        for (int _: nums) {
           qtd++;
        }

        try {
            Integer.valueOf("2");
        }catch (NumberFormatException _){
            System.out.println("teste");
        }

    }
}
