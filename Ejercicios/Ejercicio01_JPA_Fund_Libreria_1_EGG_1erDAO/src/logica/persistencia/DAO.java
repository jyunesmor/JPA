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

    public void guardar(T objeto) {
   
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
     
     //   Throwable e;
    }

    public void editar(T objeto) {
   
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
  
    }

    public void eliminar(T objeto) {
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

}

