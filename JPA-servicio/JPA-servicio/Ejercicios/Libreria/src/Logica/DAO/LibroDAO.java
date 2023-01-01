package Logica.DAO;

import Logica.entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

    public void crearLibroBD(Libro l) {
        try {
            conectar();
            guardar(l);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarLibro(Libro l) {
        try {
            conectar();
            editar(l);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarLibro(Integer id) {
        try {
            conectar();
            Libro l = em.find(Libro.class, id);
            eliminar(l);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public Libro obtenerLibro(Integer id) {
        try {
            conectar();
            return em.find(Libro.class,id);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Libro> obtenerLibros() {
        try {
            conectar();
            return em.createQuery("SELECT l FROM Libro l").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarLibroPorISBN(Long isbn) {
        try {
            conectar();
            return em.createQuery("SELECT l FROM Libro l WHERE l.isbn :busqueda")
                    .setParameter("busqueda",isbn).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarLibroPorTitulo(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT l FROM Libro l WHERE l.titulo :busqueda")
                    .setParameter("busqueda", nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarLibroPorEditorial(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre :busqueda")
                    .setParameter("busqueda", nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarLibroPorAutor(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre Like :busqueda")
                    .setParameter("busqueda",nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

}
