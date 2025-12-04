package features.java.java22.gathers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Gatherers;

/**
 * @author Renan Sereia
 * @date 02/12/2025
 */
public class GathersEx {
    public static void main(String[] args) {
        List<String> listaProdutos = new ArrayList<>();
        listaProdutos.add("Geladeira 470L");
        listaProdutos.add("TV UHD 50''");
        listaProdutos.add("TV UHD 65''");
        listaProdutos.add("Microondas 20L");
        listaProdutos.add("Geladeira 120L");
        listaProdutos.add("Computador i5 2.9Ghz 4GB 1TB HD");
        listaProdutos.add("Geladeira 500L");

        //Method reference
//        listaProdutos.forEach(System.out::println);

        //Gatherers
//        listaProdutos.stream().gather(Gatherers.windowFixed(3)).forEach(System.out::println);

        ComparaProdutos cp = new ComparaProdutos("TV");
        listaProdutos.stream().gather(cp).forEach(System.out::println);


        listaProdutos.stream().gather(Gatherers.windowFixed(3)).forEach(System.out::println);


    }
}
