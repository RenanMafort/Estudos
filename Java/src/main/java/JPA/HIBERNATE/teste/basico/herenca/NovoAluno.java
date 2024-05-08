package JPA.HIBERNATE.teste.basico.herenca;

import JPA.HIBERNATE.infra.DAO;
import JPA.HIBERNATE.modelo.basico.heranca.Aluno;
import JPA.HIBERNATE.modelo.basico.heranca.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> alunoDAO = new DAO<>();

        Aluno aluno1 = new Aluno(123L,"João");
        AlunoBolsista alunoBolsista = new AlunoBolsista(345L,"Maria",1000);

        alunoDAO.incluirAtomico(aluno1);
        alunoDAO.incluirAtomico(alunoBolsista);

        alunoDAO.fecharDAO();

    }
}
