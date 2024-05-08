package br.com.devdojo.varargs.exceptions;

import br.com.devdojo.varargs.exceptions.dominio.Leitor1;
import br.com.devdojo.varargs.exceptions.dominio.Leitor2;
import br.com.devdojo.varargs.exceptions.dominio.Leitor3;

import java.io.*;

public class TryWithResourcesTest1 {
    public static void main(String[] args) {
        lerArquivo();
    }

    public static void lerArquivo(){
        try(Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2();
            Leitor3 leitor3 = new Leitor3()){

        }catch (Exception e){

        }
    }
    public static void lerArquivo2(){
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
