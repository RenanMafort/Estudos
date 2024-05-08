package JPA.HIBERNATE.teste.basico.consulta;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.muitospramuitos.Filme;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filme = dao.consultar("filmesNotaMaiorQue",
                "nota",8.5);

        for (Filme filme1: filme)
            System.out.println(filme1.getNome());

    }
}
