package JPA.HIBERNATE.teste.basico.produto;

import JPA.HIBERNATE.infra.ProdutoDAO;
import JPA.HIBERNATE.modelo.basico.Produto;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();

        List<Produto> list = dao.obterTodos();

        for (Produto p: list) {
            System.out.println("ID:" + p.getId() + ", Produto: " + p.getNome());
        }

        double precoTotal = list.stream().map(p -> p.getPreco())
                .reduce(0D, (n, m) -> n + m);
        System.out.printf("%.2f",precoTotal);
    }
}
