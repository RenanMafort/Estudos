package br.com.dev.maratonajsf.bean.comunicacao;

import br.com.dev.maratonajsf.model.Estudante;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest6Bean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();

    public String editar(int index){
        Estudante estudante = estudanteList.get(index);
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("estudante",estudante);
        return "comunicacao7?faces-redirect=true";
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
