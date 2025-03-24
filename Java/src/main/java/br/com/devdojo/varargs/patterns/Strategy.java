package br.com.devdojo.varargs.patterns;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    public static void main(String[] args) {
        NovaJornada novaJornada = new NovaJornada();
        Legado legado = new Legado();
        Map<String, Integer> values = new HashMap<>();
        values.put("nova",2);
        values.put("velha",22);

        Integer nova = values.getOrDefault("nova", 11);

        System.out.println(nova);


    }
}
