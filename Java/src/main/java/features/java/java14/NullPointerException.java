package features.java.java14;

import java.util.Arrays;

public class NullPointerException {

    public static void main(String[] args) {
        String nome = "Olá";

//        System.out.println(nome.substring(0,10));

        Integer[] i = null;
        i[0] = 1;

        System.out.println(Arrays.toString(i));
    }
}
