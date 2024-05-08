package JPA.HIBERNATE.teste.basico.muitospramuitos;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.muitospramuitos.Sobrinho;
import JPA.HIBERNATE.modelo.basico.muitospramuitos.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tia1 = new Tio("Maria");
        Tio tio2 = new Tio("João");

        Sobrinho sobrinho1 = new Sobrinho("David");
        Sobrinho sobrinho2 = new Sobrinho("Ana");

        tia1.getSobrinhoList().add(sobrinho1);
        sobrinho1.getTioList().add(tia1);

        tia1.getSobrinhoList().add(sobrinho2);
        sobrinho2.getTioList().add(tia1);

        tio2.getSobrinhoList().add(sobrinho1);
        sobrinho1.getTioList().add(tio2);

        tio2.getSobrinhoList().add(sobrinho2);
        sobrinho2.getTioList().add(tio2);

        DAO<Object> dao = new DAO<>();
        dao.abrirTransacao()
                .incluir(tia1)
                .incluir(tio2)
                .incluir(sobrinho1)
                .incluir(sobrinho2)
                .commitTransacao()
                .fecharDAO();
    }
}
