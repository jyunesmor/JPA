package logica.Persistencia;

import logica.Dominio.Libro;
import logica.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public LibroJpaController() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = libro.getIsbn();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Libro findLibro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Libro> buscarLibroPorISBN(Long isbn) throws Exception {
        List<Libro> libro = new ArrayList();
        EntityManager em = getEntityManager();
        libro = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :busqueda")
                .setParameter("busqueda", isbn).getResultList();
        em.close();
        return libro;
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) throws Exception {
        List<Libro> libro = new ArrayList();
        EntityManager em = getEntityManager();
        libro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :busqueda")
                .setParameter("busqueda", titulo).getResultList();
        em.close();
        return libro;
    }

    public List<Libro> buscarLibroPorAutor(String nombre) throws Exception {
        List<Libro> libro = new ArrayList();
        EntityManager em = getEntityManager();
        libro = em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre like :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.close();
        return libro;
    }

    public List<Libro> buscarLibroPorEditorial(String nombre) throws Exception {
        List<Libro> libro = new ArrayList();
        EntityManager em = getEntityManager();
        libro = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre like :busqueda")
                .setParameter("busqueda", "%" + nombre + "%").getResultList();
        em.close();
        return libro;
    }

}

