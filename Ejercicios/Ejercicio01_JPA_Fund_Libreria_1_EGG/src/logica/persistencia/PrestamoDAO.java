package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Prestamo;

public class PrestamoDAO {

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

    public void crearPrestamoBD(Prestamo p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    public void modificarPrestamo(Prestamo p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }        
    }

    public void eliminarPrestamo(Integer id) {
        Prestamo p = em.find(Prestamo.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public Prestamo obtenerPrestamo(Integer id) {
        em.getTransaction().begin();
        Prestamo pre = em.find(Prestamo.class, id);
        return pre;
    }

    public List<Prestamo> obtenerPrestamos() {
        em.getTransaction().begin();
        List list = em.createQuery("SELECT p FROM Prestamo p").getResultList();
        return list;
    }

}
