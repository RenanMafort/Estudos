package JPA.HIBERNATE.teste.basico.usuario;

import JPA.HIBERNATE.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-dev-dojo");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from Usuario u ";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(50);

        List<Usuario> usuarios = query.getResultList();

        for (Usuario user: usuarios){
            System.out.println("ID: " + user.getId() + " Email: " + user.getEmail()
            + " Nome: " + user.getNome());
        }

        //MESMA COISA QUE O MÉTODO ACIMA
//        List<Long> usuarios2 = query.getResultList().stream().map( n -> n.getId()).filter(n -> n >=5).filter(n -> n <=45).limit(50).toList();
//        for (Long user: usuarios2){
//            System.out.println("ID: " +user);
//        }

        em.close();
        emf.close();

    }
}
