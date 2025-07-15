package br.com.devdojo.varargs.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileReader fileReader = new FileReader(file)) {
            char[] in = new char[100];
            int size = fileReader.read(in);
            System.out.println(size);
            for (char buff: in){
                System.out.print(buff);
            }

//            int i;
//            while ((i= fileReader.read()) != -1){//-1 é o ultimo caracter
//                System.out.print((char)i);
//            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
