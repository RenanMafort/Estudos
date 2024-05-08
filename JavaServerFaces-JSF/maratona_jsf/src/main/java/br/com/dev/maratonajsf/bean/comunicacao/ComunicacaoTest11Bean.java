package br.com.dev.maratonajsf.bean.comunicacao;

import br.com.dev.maratonajsf.model.Estudante;
import br.com.dev.maratonajsf.util.ApplicationMapUti;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest11Bean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();

    public String editar(Estudante estudante){
        ApplicationMapUti.setValueInApplicationMap("estudante",estudante);
        return "comunicacao12?faces-redirect=true";
    }


    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
