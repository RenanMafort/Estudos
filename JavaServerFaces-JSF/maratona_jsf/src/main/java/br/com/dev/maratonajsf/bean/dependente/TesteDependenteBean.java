package br.com.dev.maratonajsf.bean.dependente;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Renan on 17/01/2023.
 */
@Named
@Dependent //Escopo padrão caso não tenha a anotação
public class TesteDependenteBean implements Serializable {
    private List<String> personagens ;
    private List<String> personagemSelecionado= new ArrayList<>();
    private List<String> categoriasList= new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("entrou no postConstruct Dependent");
        personagens = Arrays.asList("Goku", "Vegeta", "Gohan");

    }

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }

    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);

    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

}
