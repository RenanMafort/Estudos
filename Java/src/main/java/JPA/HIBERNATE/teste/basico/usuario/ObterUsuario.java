package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-dev-dojo");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class,1L);

        em.close();
        emf.close();

        System.out.println(usuario.getNome());
    }
}
