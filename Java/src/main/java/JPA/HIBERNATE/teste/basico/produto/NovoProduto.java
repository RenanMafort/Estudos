package JPA.HIBERNATE.teste.basico.produto;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);

        Produto produto = new Produto("TV 22'",3227.45);
//        dao.abrirTransacao().incluir(produto).commitTransacao().fecharDAO();

        dao.incluirAtomico(produto).fecharDAO();
    }

}
