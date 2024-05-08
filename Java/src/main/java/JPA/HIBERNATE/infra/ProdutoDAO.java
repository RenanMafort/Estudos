package JPA.HIBERNATE.infra;

import JPA.HIBERNATE.modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }
}
