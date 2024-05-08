package JPA.HIBERNATE.modelo.basico.consulta;

import JPA.HIBERNATE.infra.DAO;

import java.io.File;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme obterMediaGeral = dao.consultarUm("obterMediaGeral");

        System.out.println(obterMediaGeral.getMedia());
    }
}
