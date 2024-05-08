package br.com.devdojo.varargs.io;

import java.io.*;

public class BufferReader01 {
    public static void main(String[] args) {
//        File file = new File("file.txt");
//        try(FileReader fw = new FileReader(file);
//            BufferedReader bw = new BufferedReader(fw)) {
//            String linha;
//            while ((linha = bw.readLine()) !=null){
//                System.out.println(linha);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileReader fr = new FileReader("teste.csv");
             BufferedReader bw = new BufferedReader(fr);){
            String linha;
            while ((linha = bw.readLine()) != null){
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
