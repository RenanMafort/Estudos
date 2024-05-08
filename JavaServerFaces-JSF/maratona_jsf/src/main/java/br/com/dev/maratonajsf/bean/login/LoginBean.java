package br.com.dev.maratonajsf.bean.login;

import br.com.dev.maratonajsf.model.Estudante;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Renan on 19/01/2023.
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String nome ;
    private String senha;
    private Estudante estudante;
    private List<Locale> localeList = Arrays.asList(new Locale("en"), new Locale("pt"));
    private String language;
    private int qtdeMessages;

    public String logar(){
        if (nome.equalsIgnoreCase("renan") && senha.equalsIgnoreCase("1234")){
            estudante = new Estudante();
            qtdeMessages++;
            return "/restricted/iniciosistema.xhtml?faces-redurect=true";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario ou senhas invalidos",""));

        return null;
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        qtdeMessages++;
        estudante = null;
        return "/login?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Locale> getLocaleList() {
        return localeList;
    }

    public void setLocaleList(List<Locale> localeList) {
        this.localeList = localeList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQtdeMessages() {
        return qtdeMessages;
    }

    public void setQtdeMessages(int qtdeMessages) {
        this.qtdeMessages = qtdeMessages;
    }
}
