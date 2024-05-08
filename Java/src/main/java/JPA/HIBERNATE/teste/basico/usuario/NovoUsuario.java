package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("java-dev-dojo");//info do banco de dados contigo no persistence.xml
        EntityManager em = emf.createEntityManager();

            Usuario newUser = new Usuario("Renan Mafort Sereia"  ,"renansereia@mafort");

            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();

        em.close();
        emf.close();

//        System.out.println("O id gerado foi - " + newUser.getId());

    }
}
