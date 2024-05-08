package br.com.dev.maratonajsf.bean.ValidatorTestBean;

import br.com.dev.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 25/01/2023.
 */
@Named
@ViewScoped
public class validator implements Serializable{
    private Estudante estudante = new Estudante();

    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante.getEmail());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
