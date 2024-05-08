package JPA.HIBERNATE.modelo.basico.muitospramuitos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sobrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "sobrinhoList")
    private List<Tio> tioList = new ArrayList<>();

    public Sobrinho() {
    }

    public Sobrinho(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tio> getTioList() {
        return tioList;
    }

    public void setTioList(List<Tio> tioList) {
        this.tioList = tioList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
