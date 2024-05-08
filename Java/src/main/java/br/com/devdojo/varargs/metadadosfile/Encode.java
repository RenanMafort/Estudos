package br.com.devdojo.varargs.metadadosfile;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;

public class Encode {
    public static void main(String[] args) {
        String name = "Renan";
        System.out.println("String .getBytes() " + Arrays.toString(name.getBytes()));
        byte[] encode = Base64.getEncoder().encode(name.getBytes());
        System.out.println(Arrays.toString(encode));
    }
}
