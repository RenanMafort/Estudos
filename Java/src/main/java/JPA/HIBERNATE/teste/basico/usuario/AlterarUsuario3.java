package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-dev-dojo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class,1L);
        usuario.setNome("Testando 'detach' ");

        em.detach(usuario);// NÃO DEIXA O USUARIO EM ESTADO DE TRANSAÇÃO

        em.merge(usuario);

        em.getTransaction().commit();


        emf.close();
        em.close();
    }
}
