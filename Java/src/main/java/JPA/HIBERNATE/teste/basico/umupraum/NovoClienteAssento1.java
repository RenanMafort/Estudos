package JPA.HIBERNATE.teste.basico.umupraum;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.umpraum.Assento;
import JPA.HIBERNATE.modelo.basico.umpraum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {

        Assento assento = new Assento("13A");
        Cliente cliente = new Cliente("Sereia",assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirTransacao().incluir(assento).incluir(cliente)
                .commitTransacao().fecharDAO();



    }
}
