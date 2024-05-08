package br.com.dev.maratonajsf.bean.view;

import br.com.dev.maratonajsf.bean.dependente.TesteDependenteBean;
import br.com.dev.maratonajsf.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
@ViewScoped
public class TestViewBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private final TesteDependenteBean dependenteBean;

    private final TesteSessionBean testeSessionBean;


    @Inject
    public TestViewBean(TesteDependenteBean dependenteBean, TesteSessionBean testeSessionBean) {
        this.dependenteBean = dependenteBean;
        this.testeSessionBean = testeSessionBean;
    }


    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ViewScoped");
        personagens = Arrays.asList("Goku", "Vegeta", "Gohan");

    }


    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
        dependenteBean.getPersonagemSelecionado().add(personagem);

    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public TesteDependenteBean getDependenteBean() {
        return dependenteBean;
    }

    public TesteSessionBean getTesteSessionBean() {
        return testeSessionBean;
    }
}
