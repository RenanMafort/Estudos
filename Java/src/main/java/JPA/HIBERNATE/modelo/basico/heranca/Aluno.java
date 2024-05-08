package JPA.HIBERNATE.modelo.basico.heranca;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",length = 2,discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")
public class Aluno {

    @Id
    private Long matricula;

    private String nome;

    public Aluno() {
    }

    public Aluno(Long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
