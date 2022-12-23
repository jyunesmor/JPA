/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author Diego
 */
public class AutorDao extends Dao<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public List<Autor> listarAutores() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }

    public List<Autor> buscarAutores(String busquedaDeAutor) throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a where a.nombre like :busqueda")
                .setParameter("busqueda", "%" + busquedaDeAutor + "%").getResultList();
        desconectar();
        return autores;
    }

    public Autor SeleccionAutor(Integer id) throws Exception {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public void editar(Autor autor) {
        super.editar(autor);
    }
}
