package br.com.devdojo.varargs.serialization;

import br.com.devdojo.varargs.serialization.dominio.Aluno;
import br.com.devdojo.varargs.serialization.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationTest01<T> {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L,"Renan","1234");
        Turma turma = new Turma("9b","9c","9d");
        aluno.setTurma(turma);
//        serializar(aluno);
        deserializar();
    }

    private static void serializar(Aluno aluno){
        Path path = Paths.get("aluno.ser");
        try(ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(path))){
            oss.writeObject(aluno);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void deserializar(){
        Path path = Paths.get("aluno.ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            Object aluno = ois.readObject();
            System.out.println(aluno);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
