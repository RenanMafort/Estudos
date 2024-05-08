package JPA.HIBERNATE.modelo.basico.muitospramuitos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany
    private List<Sobrinho> sobrinhoList = new ArrayList<>();

    public Tio() {
    }

    public Tio(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Sobrinho> getSobrinhoList() {
        return sobrinhoList;
    }

    public void setSobrinhoList(List<Sobrinho> sobrinhoList) {
        this.sobrinhoList = sobrinhoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
