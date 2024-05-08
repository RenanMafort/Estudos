package br.com.devdojo.varargs.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//File
//FileWriter
//FileReader
//BufferedWriter
//BufferedReader
public class FileWriter01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file,true)) {
            fw.write("Testando escrita em arquivo\nTestando quebra linha\n");
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
