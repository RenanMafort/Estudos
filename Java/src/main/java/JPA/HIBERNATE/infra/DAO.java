package JPA.HIBERNATE.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;

    private Class<E> eClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("java-dev-dojo");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> eClass) {
        this.eClass = eClass;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> commitTransacao(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    public E obterPorId(Object id){
        return em.find(eClass,id);
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirTransacao().incluir(entidade).commitTransacao();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10,0);
    }

    public List<E> obterTodos(int qtd, int deslocamente){
        if (eClass == null){
            throw new UnsupportedOperationException("A classe é nula");
        }

        String jpql = "select e from " + eClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql,eClass);
        query.setMaxResults(qtd);
        query.setFirstResult(deslocamente);

        return query.getResultList();
    }

    public List<E> consultar(String nomeConsulta, Object... params){
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta,eClass);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(),params[i + 1]);
        }
        return query.getResultList();
    }

    public E consultarUm(String nomeConsulta, Object... params){
        List<E> lista = consultar(nomeConsulta,params);
        return lista.isEmpty() ? null : lista.get(0);
    }

    public void fecharDAO(){
        em.close();
    }
}
