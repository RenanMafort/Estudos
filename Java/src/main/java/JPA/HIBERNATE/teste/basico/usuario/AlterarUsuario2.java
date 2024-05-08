package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("java-dev-dojo");//info do banco de dados contigo no persistence.xml
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 7L);
        usuario.setNome("Minha alteração 2");

//        em.merge(usuario); //UPDATE


        em.getTransaction().commit();
        em.close();
        emf.close();

//        System.out.println("O id gerado foi - " + newUser.getId());

    }
}
