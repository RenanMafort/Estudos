package br.com.dev.maratonajsf.bean.converter;

import br.com.dev.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Renan on 25/01/2023.
 */
@Named
@ViewScoped
public class Converter implements Serializable{
    private List<Estudante> estudanteList = Estudante.estudanteList();
    private Estudante estudante = new Estudante();

    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante.toString());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
