package logica.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Cliente;

public class ClienteDAO {

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

    public void crearClienteBD(Cliente c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }  
    }

    public void modificarCliente(Cliente c) {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }  
    }

    public void eliminarCliente(Integer id) {
        Cliente c = em.find(Cliente.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();     
    }

    public Cliente obtenerCliente(Integer id) {
        em.getTransaction().begin();
        Cliente c = em.find(Cliente.class, id);
        return c;
    }

    public List<Cliente> obtenerClientes() {
        em.getTransaction().begin();
        List<Cliente> list = em.createQuery("SELECT c FROM Cliente c").getResultList();
        return list;
    }

}
