package br.com.dev.maratonajsf.model;

import br.com.dev.maratonajsf.model.enums.Turno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Renan on 08/01/2023.
 */
public class Estudante implements Serializable{
    private Integer id;
    private String nome = "Renan";
    private String sobreNome = "Sereia";
    private double nota1 = 5;
    private double nota2 = 12;
    private double nota3 = 10;
    private Turno turno = Turno.MATUTINO;
    private String email;
    private transient boolean editing;

    public Estudante() {
    }

    public Estudante(String nome, String sobreNome, double nota1) {

        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nota1 = nota1;
    }

    public Estudante(Integer id,String nome, String sobreNome, double nota1) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nota1 = nota1;
    }

    public static List<Estudante> estudanteList(){
        return new ArrayList<>(Arrays.asList(new Estudante(1,"Renan","Sereia", 10),
                new Estudante(2,"Marcos","Drja", 10),
                new Estudante(3,"Seya","Pegasus", 10)));
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudante estudante = (Estudante) o;

        return id != null ? id.equals(estudante.id) : estudante.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", turno=" + turno +
                ", email='" + email + '\'' +
                '}';
    }
}
