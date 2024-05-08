package br.com.dev.maratonajsf.bean.viewexpired;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 01/02/2023.
 */
@Named
@ViewScoped
public class ViewExpiredTesteBean implements Serializable{
    private String nome;

    public void save(){
        System.out.println(nome);
    }

    public String invalidateSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
