package JPA.HIBERNATE.teste.basico.umpramuitos;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.Produto;
import JPA.HIBERNATE.modelo.basico.umpramuitos.ItemPedido;
import JPA.HIBERNATE.modelo.basico.umpramuitos.Pedido;

public class NovoPedido {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Geladeira",2524.89);
        ItemPedido item = new ItemPedido(pedido,produto,10);

        dao.abrirTransacao()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .commitTransacao()
                .fecharDAO();
    }
}
