/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DAO;

import Logica.entidades.Prestamo;
import java.util.List;

/**
 *
 * @author Juan
 */
public class PrestamoDAO extends DAO<Prestamo>{

    
    public void crearPrestamoBD(Prestamo p) {
        try {
            conectar();
            guardar(p);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public void modificarPrestamo(Prestamo p) {
        try {
            conectar();
            editar(p);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarPrestamo(Integer id) {
        try {
            conectar();
            Prestamo p = em.find(Prestamo.class,id);
            eliminar(p);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public List<Prestamo> obtenerPrestamos() {
        try {
            conectar();
            return em.createQuery("SELECT p FROM Prestamo p").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public Prestamo obtenerPrestamo(Integer id) {
        try {
            conectar();
            return em.find(Prestamo.class,id);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    List<Prestamo> obtenerPrestamosPorDNICliente(Long dni) {
        try {
            conectar();
            return em.createQuery("SELECT p FROM Prestamo p, Cliente c WHERE c.documento : busqueda").setParameter("busqueda",dni).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
}
