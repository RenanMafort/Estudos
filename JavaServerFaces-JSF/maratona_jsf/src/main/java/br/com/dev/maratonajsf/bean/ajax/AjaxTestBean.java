package br.com.dev.maratonajsf.bean.ajax;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Renan on 28/01/2023.
 */
@Named
@ViewScoped
public class AjaxTestBean implements Serializable {
    private String nome ;
    private String sobrenome;
    private String email;
    private Map<String,List<String>> animePersonagensMap;
    private List<String> personagens;
    private String animeSelecionado;
    private String personagemSelecionado;

    @PostConstruct
    public void init(){
            animePersonagensMap = new TreeMap<>();
            animePersonagensMap.put("Hellsing", Arrays.asList("Alucard","Seras","Alexander"));
            animePersonagensMap.put("Attack on Titan", Arrays.asList("Eren","Mikasa","Armin"));
            animePersonagensMap.put("Berserk", Arrays.asList("Guts","Casca","Griffith"));
        }

    public void onSelectAnime(){
        if (animeSelecionado ==null){
            personagens = null;
            return;
        }

        personagens=animePersonagensMap.get(animeSelecionado);
    }

    public void toUpperCase(AjaxBehaviorEvent event){
        Behavior behavior = event.getBehavior();
        UIComponent component = event.getComponent();
        PhaseId phaseId = event.getPhaseId();

        this.nome = this.nome.toUpperCase();
        this.sobrenome = this.sobrenome.toUpperCase();
    }

    public void toUpperCaseNome(){
        this.nome = this.nome != null ? this.nome.toUpperCase() : null;
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

    public Map<String, List<String>> getAnimePersonagensMap() {
        return animePersonagensMap;
    }

    public void setAnimePersonagensMap(Map<String, List<String>> animePersonagensMap) {
        this.animePersonagensMap = animePersonagensMap;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public String getAnimeSelecionado() {
        return animeSelecionado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAnimeSelecionado(String animeSelecionado) {
        this.animeSelecionado = animeSelecionado;
    }

    public String getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(String personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
