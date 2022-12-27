package logica.persistencia;

import java.util.List;
import logica.Dominio.Editorial;

public class EditorialDAO extends DAO<Editorial> {


    public void crearEditorialBD(Editorial ed) {
        try {
            conectar();
            guardar(ed);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarEditorialBD(Editorial ed) {
        try {
            conectar();
            modificarEditorialBD(ed);
        } catch (Exception e) {
            throw e;
        } finally {
          desconectar();
        }
    }

    public void eliminarEditorial(String id) {
        conectar();
        Editorial ed = em.find(Editorial.class, id);
        eliminar(ed);
        desconectar();
    }

    public Editorial obtenerEditorial(String id) {
        conectar();
        Editorial ed = em.find(Editorial.class, id);
        desconectar();
        return ed;
    }

    public List<Editorial> obtenerEditoriales() {
        conectar();
        List<Editorial> list = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return list;
    }

}
