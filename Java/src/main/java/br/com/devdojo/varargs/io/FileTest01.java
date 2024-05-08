package br.com.devdojo.varargs.io;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println(isCreated);
            System.out.println("Path "+file.getPath());
            System.out.println("Path AbsoluthPath "+file.getAbsolutePath());
            System.out.println("is directory "+file.isDirectory());
            System.out.println("is file "+file.isFile());
            System.out.println("is hidden "+file.isHidden());
            System.out.println("Last modified - " + new Date(file.lastModified()));
            System.out.println("Last modified - " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());

            if (file.exists()){
                System.out.println(file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
