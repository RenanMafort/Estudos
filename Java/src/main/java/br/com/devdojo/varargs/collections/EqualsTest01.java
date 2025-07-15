package br.com.devdojo.varargs.collections;

import br.com.devdojo.varargs.collections.dominio.SmartPhone;

import java.util.Objects;

public class EqualsTest01 {
    public static void main(String[] args) {

        String nome = "Renan Sereia";
        String nome2 = new String("Renan Sereia");

        System.out.println(nome == nome2);

        SmartPhone smartPhone1 = new SmartPhone("1ABA","SAMSUNG");
        SmartPhone smartPhone2 = new SmartPhone("1ABA","SAMSUNG");
//
        System.out.println(smartPhone1 == smartPhone2);
        System.out.println(smartPhone1.equals(smartPhone2));

        System.out.println(smartPhone1.hashCode());
        System.out.println(smartPhone2.hashCode());

//        System.out.println(Objects.hash("M"));
//        System.out.println(Objects.hash("SAMM"));


    }
}
