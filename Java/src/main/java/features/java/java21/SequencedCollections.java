package features.java.java21;

import java.util.LinkedHashSet;
import java.util.SequencedCollection;

/**
 * @author Renan Sereia
 * @date 25/11/2025
 */
public class SequencedCollections {
    public static void main(String[] args) {
        SequencedCollection<String> frutas = new LinkedHashSet<>();
        frutas.add("banana");
        frutas.add("maça");
        frutas.add("laranja");
        frutas.add("abacaxi");

        frutas.addFirst("limao");
        frutas.addLast("abacate");

        frutas.forEach(System.out::println);
    }
}
