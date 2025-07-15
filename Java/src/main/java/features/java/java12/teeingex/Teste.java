package features.java.java12.teeingex;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Renan Sereia
 * @date 08/07/2025
 */
public class Teste {
    public static void main(String[] args) {
        Long resultado = Stream.of(50, 15, 251, 123, 5, 15).collect(
                Collectors.teeing(Collectors.summarizingDouble(i -> i),Collectors.counting(), (soma, qtde) -> soma.getCount() / qtde)
        );

        System.out.println(resultado);
    }
}
