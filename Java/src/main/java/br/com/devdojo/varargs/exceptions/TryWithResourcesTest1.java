package br.com.devdojo.varargs.exceptions;

import br.com.devdojo.varargs.exceptions.dominio.Leitor1;
import br.com.devdojo.varargs.exceptions.dominio.Leitor2;
import br.com.devdojo.varargs.exceptions.dominio.Leitor3;

import java.io.*;

public class TryWithResourcesTest1 {
    public static void main(String[] args) {
        lerArquivoTeste();
    }

    public static void lerArquivo(){
        try(Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2();
            Leitor3 leitor3 = new Leitor3()){

            leitor3.teste();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void lerArquivoTeste(){

        try{
            File file = new File("arquivos/teste.txt");
            boolean newFile = file.createNewFile();
            System.out.println("Arquivo is created? :" + newFile);
        }catch (IOException e){
            e.printStackTrace();
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
