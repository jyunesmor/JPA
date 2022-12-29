
package Logica.DAO;

import Logica.entidades.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {

    public void crearEditorialBD(Editorial e) {
        try {
            conectar();
            guardar(e);
        } catch (Exception ex) {
            throw ex;
        } finally{
            desconectar();          
        }        
    } 
    
    public void modificarEditorialBD(Editorial e) {
        try {
            conectar();
            editar(e);
        } catch (Exception ex) {
            throw ex;
        } finally{
            desconectar();          
        }
    }
    
    public void eliminarEditorial(Integer id) {
        try {
            conectar();
            Editorial e = em.find(Editorial.class,id);
            eliminar(e);
        } catch (Exception ex) {
            throw ex;
        } finally{
            desconectar();          
        }
    }    
    
    public List<Editorial> obtenerEditoriales() {
        try {
            conectar();
            return em.createQuery("SELECT e FROM Editorial e").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public Editorial obtenerEditorial(Integer id) {
        try {
            conectar();
            return em.find(Editorial.class,id);
        } catch (Exception ex) {
            throw ex;
        } finally{
            desconectar();          
        }
    }

    public List<Editorial> buscarEditorialPorTitulo(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT e FROM Editorial e WHERE e.nombre :busqueda")
                    .setParameter("busqueda", nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
 
}
