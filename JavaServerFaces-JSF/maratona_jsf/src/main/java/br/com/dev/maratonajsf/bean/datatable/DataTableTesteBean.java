package br.com.dev.maratonajsf.bean.datatable;

import br.com.dev.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Renan on 26/01/2023.
 */
@Named
@ViewScoped
public class DataTableTesteBean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();
    private Set<Estudante> estudanteSet = new HashSet<>(Estudante.estudanteList());
    private List<Estudante> estudanteLinkedList = new LinkedList<>(Estudante.estudanteList());
    private Map<String, Estudante> mapEstudanteist = new HashMap<>();

    public void init(){
        mapEstudanteist.put("Estudante 1",new Estudante(1,"Renan","Sereia", 10));
        mapEstudanteist.put("Estudante 2",new Estudante(2,"Marcos","Drja", 10));
        mapEstudanteist.put("Estudante 3",new Estudante(3,"Seya","Pegasus", 10));
        mapEstudanteist.put("Estudante 4",new Estudante(4,"Renan","Sereia", 10));
    }


    public void orderByNome(String ordem){
        if (ordem.equals("asc")){
            estudanteList.sort(Comparator.comparing(Estudante::getNome));
        }else{
            estudanteList.sort(Comparator.comparing(Estudante::getNome).reversed());
        }
    }

    public void remove(Estudante estudante){
        //Faz uma chamada para o banco
        estudanteList.remove(estudante);
    }

    public void orderBySobreNome(String ordem){
        if (ordem.equals("asc")){
            estudanteList.sort(Comparator.comparing(Estudante::getSobreNome));
        }else{
            estudanteList.sort(Comparator.comparing(Estudante::getSobreNome).reversed());
        }
    }

    public void save(){
        estudanteList.forEach(estudante -> {
            if (estudante.isEditing())
                System.out.println(estudante);

            estudante.setEditing(Boolean.FALSE);

        });
    }

    public void edit(Estudante estudante){
        estudante.setEditing(true);
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    public Set<Estudante> getEstudanteSet() {
        return estudanteSet;
    }

    public void setEstudanteSet(Set<Estudante> estudanteSet) {
        this.estudanteSet = estudanteSet;
    }

    public List<Estudante> getEstudanteLinkedList() {
        return estudanteLinkedList;
    }

    public void setEstudanteLinkedList(List<Estudante> estudanteLinkedList) {
        this.estudanteLinkedList = estudanteLinkedList;
    }

    public Map<String, Estudante> getMapEstudanteist() {
        return mapEstudanteist;
    }

    public void setMapEstudanteist(Map<String, Estudante> mapEstudanteist) {
        this.mapEstudanteist = mapEstudanteist;
    }
}
