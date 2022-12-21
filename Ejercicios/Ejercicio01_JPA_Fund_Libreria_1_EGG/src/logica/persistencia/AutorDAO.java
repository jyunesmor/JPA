package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Autor;

public class AutorDAO {

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


    public void crearAutorBD(Autor a) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarAutorPorId(Long id) {
        conectar();
        Autor a = em.find(Autor.class, id);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        desconectar();
    }

    public List<Autor> obtenerAutores() {
        conectar();
        em.getTransaction().begin();
        List<Autor> list = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return list;
    }

    public Autor obtenerAutor(Long id) {
        conectar();
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public void modificarAutor(Autor a) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally{
            desconectar();
        }
    }

    public List<Autor> buscarAutorPorNombre(String nombre) {
        conectar();
        em.getTransaction().begin();
        List<Autor> list = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        desconectar();
        return list;
    }

}
