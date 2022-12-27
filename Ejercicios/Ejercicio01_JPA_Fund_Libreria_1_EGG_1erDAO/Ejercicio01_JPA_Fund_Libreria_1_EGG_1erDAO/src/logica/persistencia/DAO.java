/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan
 */
public abstract class DAO<T> {

    protected EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria_DAOPU");
    protected EntityManager em = EMF.createEntityManager();

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

    public void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
     //   Throwable e;
    }

    public void editar(T objeto) {
        conectar();
        em.merge(objeto);
        desconectar();
    }

    public void eliminar(T objeto) {
        conectar();
        em.remove(objeto);
        desconectar();
    }

}

