package JPA.HIBERNATE.teste.basico.umupraum;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.umpraum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {
        DAO< Cliente> dao = new DAO<>(Cliente.class);

        Cliente cliente = dao.obterPorId(1L);
        String nome = cliente.getAssento().getNome();
        System.out.println(nome);

    }
}
