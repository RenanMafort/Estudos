package features.java.java9.tryresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Renan Sereia
 * @date 06/07/2025
 */
public class Teste {
    public static void main(String[] args) {

        try {
            lerArquivoComBlocoTryCatchFinally("file.txt");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //Antes do java 7 - "modo tradicional"
    public static void lerArquivoComBlocoTryCatchFinally(String path) throws IOException {
        String linha = "";

        BufferedReader bf = new BufferedReader(new FileReader(path));

        try {
            while ((linha = bf.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw e;
        }finally {
            bf.close();
        }
    }

    //Apartir do java 7
    public static void lerArquivoBlocoTryComRecurso(String path) throws IOException{
        String linha = "";

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            while ((linha = bf.readLine()) != null){
                System.out.println(linha);
            }
        }
    }

    //Apartir do java 9
    public static void lerArquivoBlocoTryComRecursoJava9(String path) throws IOException{
        String linha = "";
        BufferedReader bf = new BufferedReader(new FileReader(path));

        try(bf){
            while ((linha = bf.readLine()) != null){
                System.out.println(linha);
            }
        }

    }
}
