package br.com.dev.maratonajsf.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest2Bean implements Serializable {
    @Inject @Param(name = "nome")
    private String nome;
    @Inject @Param(name = "sobrenome")
    private String sobrenome;

    @PostConstruct
    public void init(){
        System.out.println("Criou comunicacao 2");
//        Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        nome = paramsMap.get("nome");
//        sobrenome = paramsMap.get("sobrenome");
        System.out.println(nome);
        System.out.println(sobrenome);
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
