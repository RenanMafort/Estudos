package JPA.HIBERNATE.teste.basico.umpramuitos;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.umpramuitos.ItemPedido;
import JPA.HIBERNATE.modelo.basico.umpramuitos.Pedido;

public class ObterPedido {

    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);
        Pedido pedido = dao.obterPorId(1L);
        dao.fecharDAO();

        for(ItemPedido item : pedido.getItens()){
            System.out.println(item.getQuantidade());
            System.out.println(item.getProduto().getNome());
        }

    }
}
