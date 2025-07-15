package br.com.devdojo.varargs.io.teste;

import org.apache.commons.lang.WordUtils;

public class TesteCapitalize {
    public static void main(String[] args) {

        System.out.println(WordUtils.capitalizeFully("ANO_MES_REFERENCIA",new char[]{'_'}).replaceAll("_",""));

    }
}
