package br.com.devdojo.varargs.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","teste");
        map.put("2","testando");
        map.put("3","testando2");

        for (Map.Entry<String, String> a :map.entrySet() ){
            System.out.println(a.getKey() + a.getValue());
        }

        System.out.println(map.containsKey("1"));
    }
}
