package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Editorial;

public class EditorialDAO {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria_EGGPU");
    private EntityManager em = EMF.createEntityManager();

    public void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void crearEditorialBD(Editorial ed) {
        try {
            em.getTransaction().begin();
            em.persist(ed);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    public void modificarEditorialBD(Editorial ed) {
        try {
            em.getTransaction().begin();
            em.merge(ed);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    public void eliminarEditorial(String id) {
        Editorial ed = em.find(Editorial.class, id);
        em.getTransaction().begin();
        em.remove(ed);
        em.getTransaction().commit();
        em.close();
    }

    public Editorial obtenerEditorial(String id) {
        em.getTransaction().begin();
        Editorial ed = em.find(Editorial.class, id);
        return ed;
    }

    public List<Editorial> obtenerEditoriales() {
        em.getTransaction().begin();
        List<Editorial> list = em.createQuery("SELECT e FROM Editorial e").getResultList();
        return list;
    }

}