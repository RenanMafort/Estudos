package br.com.dev.maratonajsf.bean.html5;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Renan on 29/01/2023.
 */
@Named
@ViewScoped
public class Html5TestBean implements Serializable {
    private String email;
    private String url;
    private String nome;
    private int numero;
    private Map<String,String> atributes = new HashMap<>();

    public void init(){
        atributes.put("type","email");
        atributes.put("placeholder","Digite seu email");
    }

    public void salvar(){
        System.out.println("Salvando");
        System.out.println(url);
        System.out.println(numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void toUpperCaseNome(){
        this.nome = this.nome.toUpperCase();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Map<String,String> getAtributes(){
        return this.atributes;
    }

    public void setAtributes(Map<String,String> atributes){
        this.atributes = atributes;
    }
}
