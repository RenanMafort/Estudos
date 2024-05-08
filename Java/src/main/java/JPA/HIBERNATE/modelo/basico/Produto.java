package JPA.HIBERNATE.modelo.basico;

import javax.persistence.*;

@Entity
@Table(name = "produtos",schema = "jpa_hibernate")
public class Produto implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_nome",length = 200, nullable = false)
    private String nome;

    @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
    private Double preco;

    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
