package br.com.devdojo.varargs.serialization.dominio;

import java.io.*;

public class Aluno implements Serializable  {


    @Serial
    private static final long serialVersionUID = 8087655804392407880L;
    private long id;
    private String nome;
    private transient String password;
    private transient Turma turma;
    private static String nomeEscola = "Java";

    public Aluno(long id, String nome, String password) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }


    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Serial
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            String nomeTurma = ois.readUTF();
            turma = new Turma(nomeTurma);
            System.out.println(nomeTurma);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", escola='" + nomeEscola + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }

}
