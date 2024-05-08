package br.com.dev.maratonajsf.bean.comunicacao;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest1Bean implements Serializable {
    private String nome;
    private String sobrenome;
    private Date data = new Date();


    public void imprimirAtributos(){
        String initParameter = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("images.location");
        System.out.println(initParameter);
    }

    public String save(){
        System.out.println(this.nome);
        System.out.println(this.sobrenome);

        return "comunicacao2?faces-redirect=true&nome="+nome+"&sobrenome="+sobrenome;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
