package br.com.devdojo.varargs.exceptions;

import java.io.File;
import java.io.IOException;

public class ExceptionTest2 {
    public static void main(String[] args) throws IOException{
            criarNovoArquivo();
    }

    public static void criarNovoArquivo() throws IOException {
        File file = new File("arquivsdao\\teste2.txt");
        try {
            boolean criado = file.createNewFile();
            System.out.println("Arquivo criado? = " + criado);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                throw e;
            } catch (IOException ex) {
                try {
                    throw ex;
                } catch (IOException exc) {
                    try {
                        throw e;
                    } catch (IOException ioException) {
                        try {
                            throw ioException;
                        } catch (IOException exception) {
                            try {
                                throw exception;
                            } catch (IOException e1) {
                                try {
                                    throw e1;
                                } catch (IOException e2) {
                                   try{
                                       throw e2;
                                   }catch (IOException e3){
                                       try{
                                           throw e3;
                                       }catch (IOException asa){
                                          throw asa;
                                       }
                                   }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
