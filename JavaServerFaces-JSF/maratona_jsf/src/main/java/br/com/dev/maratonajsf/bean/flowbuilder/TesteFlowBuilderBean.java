package br.com.dev.maratonajsf.bean.flowbuilder;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 15/01/2023.
 */
@Named
@FlowScoped(value = "newregistration")
public class TesteFlowBuilderBean implements Serializable {
    private String nome;
    private String sobrenome;
    private String endereco;

    public void salvar(){
        System.out.println("Salvando no banco");
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(endereco);
//        return "exitToInicio";
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

    public void setSobrenome(String sobreome) {
        this.sobrenome = sobreome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
