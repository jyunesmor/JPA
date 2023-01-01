/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Diego
 */
public class LibroDao extends Dao<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public List<Libro> listarLibros() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarLibrosAlta() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.alta = true").getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarLibrosBaja() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.alta = false").getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarLibrosPrestados() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l where l.ejemplaresPrestados > 0").getResultList();
        desconectar();
        return libros;
    }

    public void editar(Libro libro) {
        super.editar(libro);
    }

    public List<Libro> buscarLibro(Integer OPCION, String dato) throws Exception {
        conectar();
        List<Libro> libro = new ArrayList();
        Long ISBN = Long.parseLong(dato);
        switch (OPCION) {
            case 1:
                libro = em.createQuery("SELECT l FROM Libro l WHERE l.ISBN = :busqueda")
                        .setParameter("busqueda", ISBN ).getResultList();
//                libro = em.createQuery("SELECT l FROM Libro l WHERE CONCAT(l.ISBN , '') like :busqueda")
//                        .setParameter("busqueda", "%" + dato + "%").getResultList();
                //LA FUNCIÓN "CAST" EN LA CLÁUSULA WHERE TRASNFORMA LA COLUMNA ISBN QUE ES LONG 
                //EN STRING, DE ESA MANERA PODEMOS BUSCAR CON LA CLÁUSULA LIKE
                break;
            case 2:
                libro = em.createQuery("SELECT l FROM Libro l where l.titulo like :busqueda")
                        .setParameter("busqueda", "%" + dato + "%").getResultList();
                break;
            case 3:
                libro = em.createQuery("SELECT l FROM Libro l join l.autor a where a.nombre like :busqueda")
                        .setParameter("busqueda", "%" + dato + "%").getResultList();
                break;
            case 4:
                libro = em.createQuery("SELECT l FROM Libro l join l.editorial e where e.nombre like :busqueda")
                        .setParameter("busqueda", "%" + dato + "%").getResultList();
                break;
        }
        desconectar();
        return libro;
    }
}
