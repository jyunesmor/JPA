package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Libro;

public class LibroDAO {

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

    public void crearLibroBD(Libro l) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarLibro(Libro l) {

    }

    public void eliminarLibro(Libro l) {
        try {
            System.out.println(l.toString());
            conectar();
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        }
        catch (Exception e) 
        {
            throw e;
        } finally {
            desconectar();
        }

    }

    public Libro obtenerLibro(Long id) {
        conectar();
        em.getTransaction().begin();
        Libro lib = em.find(Libro.class, id);
        desconectar();
        return lib;
    }

    public List<Libro> obtenerLibros() {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return list;
    }

    public List<Libro> buscarLibroPorISBN(Long id) {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :busqueda")
                .setParameter("busqueda", id).getResultList();
        desconectar();
        return list;
    }

    public List<Libro> buscarLibroPorTitulo(String nombre) {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.getTransaction().commit();
        desconectar();
        return list;
    }

    public List<Libro> buscarLibroPorEditorial(String nombre) {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l, Editorial e WHERE e.nombre LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.getTransaction().commit();
        desconectar();
        return list;
    }

    public List<Libro> buscarLibroPorAutor(String nombre) {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l, Autor a WHERE a.nombre LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.getTransaction().commit();
        desconectar();
        return list;
    }

}
