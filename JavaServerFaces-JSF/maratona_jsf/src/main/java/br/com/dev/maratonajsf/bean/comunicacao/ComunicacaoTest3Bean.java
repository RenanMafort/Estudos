package br.com.dev.maratonajsf.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest3Bean implements Serializable {
    private String nome;
    private String sobrenome;
    private Date data;

    public void init(){

            System.out.println("Criou comunicacao 3");
            System.out.println(nome);
            System.out.println(sobrenome);

    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String save(){
        System.out.println("Salvou");
        return "resultado?faces-redirect=true&amp;includeViewParams=true";
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
