package br.com.devdojo.varargs.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class BufferWriter01 {
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        for(Map.Entry<String,String> env: getenv.entrySet()){
            System.out.println(env.getKey() +  env.getValue());
        }


        File file = new File("file_writer.txt");

        try(FileWriter fw = new FileWriter(file)){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Olá. me chamo renan!");
            bw.newLine();
            bw.write("Tenho 26 anos e sou programador!");
        }catch (IOException e){
            e.printStackTrace();
        }



//        File fileTeste = new File("fileDebora.txt");
//        try(FileWriter fw = new FileWriter(fileTeste,true);
//            BufferedWriter bw = new BufferedWriter(fw)) {
//            for (int i = 0; i < 1000000; i++) {
//                bw.write("Eu te amo");
//                bw.newLine();
//            }
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
