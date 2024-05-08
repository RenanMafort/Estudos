package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("java-dev-dojo");

        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 2L);

        if (usuario != null){
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();

        }

        emf.close();
        em.close();
    }
}
