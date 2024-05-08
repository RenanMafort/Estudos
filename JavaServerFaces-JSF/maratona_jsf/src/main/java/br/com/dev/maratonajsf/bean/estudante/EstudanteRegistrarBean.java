package br.com.dev.maratonajsf.bean.estudante;


import br.com.dev.maratonajsf.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Renan on 08/01/2023.
 */
@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {


    private Estudante estudante = new Estudante();
    private UUID id;
    private String[] nomeArray = {"DevNojo","eh","foda"};
    private List<String> list = Arrays.asList("Renan","Mafort","Sereia");
    private Set<String> nomeSet = new HashSet<>(Arrays.asList("Goku","Naruto","HAHA"));
    private Map<String,String> nomeMap = new HashMap<>();
    private boolean mostrarNotas ;
    private boolean mostrarLink ;


    public boolean isMostrarLink() {
        return mostrarLink;
    }

    public void setMostrarLink(boolean mostrarLink) {
        this.mostrarLink = mostrarLink;
    }

    {
        nomeMap.put("Goku","O mais forte");
        nomeMap.put("One piece","O mais longo");
        nomeMap.put("Naruto","O mais lenga lenga");

        for (Map.Entry<String,String> entry: nomeMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    public void executar(){
        System.out.println("Fazendo uma busca no banco dedados");
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados de alguma forma");
    }

    public void executar(String param){
        System.out.println("Fazendo uma busca no banco dedados");
        System.out.println("Processando os dados" + param);
        System.out.println("Exibindo os dados de alguma forma");
    }

    public String irParaIndex2(){
        return "index2?faces-redirect=true";
    }

    public void exibirNotar(){
        this.mostrarNotas = true;

    }
    public void esconderNotas(){
        this.mostrarNotas = false;
    }

    public void exibirLink(){
        this.mostrarLink = true;
    }

    public void esconderLink(){
        this.mostrarLink = false;

    }

    public void calcularCubo(LambdaExpression le, long value){
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(),value);
        System.out.println(result);
    }

    public Map<String, String> getNomeMap() {
        return nomeMap;
    }

    public void setNomeMap(Map<String, String> nomeMap) {
        this.nomeMap = nomeMap;
    }
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getNomeSet() {
        return nomeSet;
    }

    public void setNomeSet(Set<String> nomeSet) {
        this.nomeSet = nomeSet;
    }

    public String[] getNomeArray() {
        return nomeArray;
    }

    public void setNomeArray(String[] nomeArray) {
        this.nomeArray = nomeArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }
}
