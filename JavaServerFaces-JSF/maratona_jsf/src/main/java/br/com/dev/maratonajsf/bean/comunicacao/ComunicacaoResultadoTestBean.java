package br.com.dev.maratonajsf.bean.comunicacao;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoResultadoTestBean implements Serializable {
    private String nome;
    private String sobrenome;

    public void init(){
        System.out.println("Criou comunicacao Resultado");
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
