package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Libro;

public class LibroDAO extends DAO<Libro> {


    public void crearLibroBD(Libro libro) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarLibro(Libro libro) {

    }

    public void eliminarLibro(Libro libro) {
        super.conectar();
        super.eliminar(libro);
        super.desconectar();
    }

    public Libro obtenerLibro(Long id) {
        super.conectar();
        Libro lib = em.find(Libro.class, id);
        super.desconectar();
        return lib;
    }

    public List<Libro> obtenerLibros() {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l").getResultList();
        em.getTransaction().commit();
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
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.getTransaction().commit();
        desconectar();
        return list;
    }

}
