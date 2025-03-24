package JPA.HIBERNATE.modelo.basico.muitospramuitos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atores")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;


    @ManyToMany(mappedBy = "atores",cascade = CascadeType.PERSIST)
    private List<Filme> fIlmes = new ArrayList<>();

    public Ator() {
    }

    public Ator(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getfIlmes() {
        return fIlmes;
    }

    public void setfIlmes(List<Filme> fIlmes) {
        this.fIlmes = fIlmes;
    }
}
