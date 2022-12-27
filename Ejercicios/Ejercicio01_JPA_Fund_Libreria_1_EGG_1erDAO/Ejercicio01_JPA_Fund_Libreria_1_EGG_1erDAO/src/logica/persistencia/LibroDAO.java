package logica.persistencia;

import java.util.List;
import logica.Dominio.Libro;

public class LibroDAO extends DAO<Libro> {


    public void crearLibroBD(Libro libro) {
        try {
            guardar(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarLibro(Libro libro) {

    }

    public void eliminarLibro(Libro libro) {
        eliminar(libro);
    }

    public Libro obtenerLibro(Long id) {
        Libro lib = em.find(Libro.class, id);
        return lib;
    }

    public List<Libro> obtenerLibros() {
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l").getResultList();
        em.getTransaction().commit();
        return list;
    }

    public List<Libro> buscarLibroPorISBN(Long id) {
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :busqueda")
                .setParameter("busqueda", id).getResultList();
        return list;
    }

    public List<Libro> buscarLibroPorTitulo(String nombre) {
        conectar();
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        desconectar();
        return list;
    }

    public List<Libro> buscarLibroPorEditorial(String nombre) {
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l, Editorial e WHERE e.nombre LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        return list;
    }

    public List<Libro> buscarLibroPorAutor(String nombre) {
        em.getTransaction().begin();
        List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        return list;
    }

}
