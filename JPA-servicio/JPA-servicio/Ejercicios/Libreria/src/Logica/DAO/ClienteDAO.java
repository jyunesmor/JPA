package Logica.DAO;

import Logica.entidades.Cliente;
import java.util.List;

public class ClienteDAO extends DAO<Cliente> {

    public List<Cliente> obtenerClientes() {
        try {
            conectar();
            return em.createQuery("SELECT c FROM Cliente c ").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public Cliente obtenerCliente(Integer id) {
        try {
            conectar();
            return em.find(Cliente.class, id);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarCliente(Cliente c) {
        try {
            conectar();
            eliminar(c);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarCliente(Cliente c) {
        try {
            conectar();
            editar(c);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void crearClienteBD(Cliente c) {
        try {
            conectar();
            guardar(c);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Cliente> obtenerClientePorDNI(Long dni) {
        try {
            conectar();
            return em.createQuery("SELECT c FROM Cliente c WHERE c.documento :busqueda")
                    .setParameter("busqueda",dni).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Cliente> obtenerClientePorNombre(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT c FROM Cliente c WHERE c.nombre :busqueda")
                    .setParameter("busqueda",nombre).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Cliente> obtenerClientePorApellido(String apellido) {
        try {
            conectar();
            return em.createQuery("SELECT c FROM Cliente c WHERE c.apellido :busqueda")
                    .setParameter("busqueda",apellido).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
}
