package br.com.dev.maratonajsf.bean.session;

import br.com.dev.maratonajsf.model.Estudante;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Renan on 11/01/2023.
 */
@Named
@SessionScoped
public class TesteSessionBean implements Serializable {
    private List<String> personagens ;
    private List<String> personagemSelecionado= new ArrayList<>();

    private Estudante estudante;

    @PostConstruct
    public void init(){
        System.out.println("Entrou no postConstruck do SessionScoped");
        personagens = Arrays.asList("Goku", "Vedita", "Gohan");
        logar();
    }

    public void logar(){
        estudante = new Estudante();
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true" ;
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

    public Estudante getEstudante() {
        return estudante;
    }
}
