
package Logica.DAO;

import Logica.entidades.Autor;
import java.util.List;

public class AutorDAO extends DAO<Autor> {

    public void crearAutorBD(Autor a) {
        try {
            conectar();
            guardar(a);
        } catch (Exception e) {
            throw e;
        } finally{
            desconectar();          
        }
    }

    public void modificarAutor(Autor a) {
        try {
            conectar();
            editar(a);
        } catch (Exception e) {
            throw e;
        } finally{
            desconectar();          
        }
    }

    public void eliminarAutorPorId(Integer id) {
        try {
            conectar();
            Autor a = em.find(Autor.class, id);
            eliminar(a);
        } catch (Exception e) {
            throw e;
        } finally{
            desconectar();          
        }
    }

    public Autor obtenerAutor(Integer id) {
        try {
            conectar();
            return em.find(Autor.class, id);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Autor> obtenerAutores() {
        try {
            conectar();
            return em.createQuery("SELECT a FROM Autor a").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Autor> buscarAutorPorNombre(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT a FROM Autor a WHERE a.nombre :busqueda")
                    .setParameter("busqueda",nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

}
