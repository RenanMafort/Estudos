package br.com.dev.maratonajsf.bean.application;

import br.com.dev.maratonajsf.bean.dependente.TesteDependenteBean;
import br.com.dev.maratonajsf.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Renan on 14/01/2023.
 */
@Named
@ApplicationScoped
public class TestApplicationBean implements Serializable {
    private List<String> categoriaList;
    private final TesteDependenteBean dependenteBean;

    private final TesteSessionBean testeSessionBean;

    @Inject
    public TestApplicationBean(TesteDependenteBean dependenteBean, TesteSessionBean sessionBean) {
        this.dependenteBean = dependenteBean;
        this.testeSessionBean = sessionBean;
    }


    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = Arrays.asList("RPG","SCI-FI","TERROR");

        dependenteBean.getCategoriasList().addAll(Arrays.asList("Comedia","RomaNCE","TERROR"));
        testeSessionBean.selecionarPersonagem();
    }

    public void mudarLista(){
        categoriaList = Arrays.asList("RPG","SCI-FI","TERROR","AÇÃO","COMÉDIA","LISTA MUDADA");

    }

    public TesteSessionBean getTesteSessionBean() {
        return testeSessionBean;
    }

    public TesteDependenteBean getDependenteBean() {
        return dependenteBean;
    }
}
