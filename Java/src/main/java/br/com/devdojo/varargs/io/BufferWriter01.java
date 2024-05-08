package br.com.devdojo.varargs.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class BufferWriter01 {
    public static void main(String[] args) {
        File file = new File("file.txt");


//        try(FileWriter fw = new FileWriter(file,true);
//            BufferedWriter bw = new BufferedWriter(fw)) {
//            bw.write("Testando escrita em arquivo Testando quebra linha");
//            bw.newLine();
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        File fileTeste = new File("fileDebora.txt");
        try(FileWriter fw = new FileWriter(fileTeste,true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < 1000000; i++) {
                bw.write("Eu te amo");
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
