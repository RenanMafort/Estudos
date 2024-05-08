package br.com.dev.maratonajsf.bean.comunicacao;

import br.com.dev.maratonajsf.model.Estudante;
import org.omnifaces.util.Faces;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest10Bean implements Serializable {
    private String password;
    private List<Estudante> estudanteList = Estudante.estudanteList();

    public void remover(Estudante estudante){
        estudanteList.remove(estudante);
    }

    public void salvar(){
        System.out.println(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
