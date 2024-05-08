package br.com.dev.maratonajsf.bean.flow;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 15/01/2023.
 */
@Named
@FlowScoped(value = "registration")
public class TestFlowBean implements Serializable {
    private String nome;
    private String sobreome;
    private String endereco;

    public void salvar(){
        System.out.println("Salvando no banco");
        System.out.println(nome);
        System.out.println(sobreome);
        System.out.println(endereco);
//        return "exitToInicio";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreome() {
        return sobreome;
    }

    public void setSobreome(String sobreome) {
        this.sobreome = sobreome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
