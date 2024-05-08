package JPA.HIBERNATE.teste.basico.muitospramuitos;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.muitospramuitos.Ator;
import JPA.HIBERNATE.modelo.basico.muitospramuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {
        Filme fIlmeA = new Filme("Star wars",8.7);
        Filme fIlmeB= new Filme("Fast furious",10.00);

        Ator atorA = new Ator("Harrison Ford");
        Ator atorb= new Ator("Macalci");

        fIlmeA.adicionarAtor(atorA);
        fIlmeA.adicionarAtor(atorb);

        fIlmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<Filme>();
        dao.incluirAtomico(fIlmeA);

    }
}
