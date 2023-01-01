package logica.Persistencia;

import logica.Dominio.Autor;
import logica.Dominio.Cliente;
import logica.Dominio.Editorial;
import logica.Dominio.Libro;
import logica.Dominio.Prestamo;
import logica.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controlPersistencia {

    AutorJpaController ajpa = new AutorJpaController();
    ClienteJpaController cjpa = new ClienteJpaController();
    EditorialJpaController ejpa = new EditorialJpaController();
    LibroJpaController ljpa = new LibroJpaController();
    PrestamoJpaController pjpa = new PrestamoJpaController();

    /*  ---------         AUTOR         --------------*/
    public void crearAutor(Autor a) {
        ajpa.create(a);
    }

    public void modificarAutor(Autor a) {
        try {
            ajpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarAutor(Long id) {
        try {
            ajpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor obtenerAutor(Long id) {
        return ajpa.findAutor(id);
    }

    public List<Autor> obtenerAutores() {

        return ajpa.findAutorEntities();
    }

    public List<Autor> obtenerAutorPorNombre(String nombre) {
        return ajpa.buscarAutores(nombre);
    }
    

    /*  --------          LIBRO         --------------*/
    public void crearLibroBD(Libro l) {
        try {
            ljpa.create(l);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarLibroBD(Libro l) {
        try {
            ljpa.edit(l);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarLibroBD(Long id) {
        try {
            ljpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro obtenerLibro(Long id) {
        return ljpa.findLibro(Long.MIN_VALUE);
    }

    public List<Libro> obtenerLibros() {
        return ljpa.findLibroEntities();
    }

    public List<Libro> obtenerLibroPorISBN(Long id) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ljpa.buscarLibroPorISBN(id);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    public List<Libro> obtenerLibroPorTitulo(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ljpa.buscarLibroPorTitulo(nombre);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    public List<Libro> obtenerLibroPorEditorial(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ljpa.buscarLibroPorEditorial(nombre);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }
    
    public List<Libro> obtenerLibroPorAutor(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ljpa.buscarLibroPorAutor(nombre);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }    
    

    /*  -------         EDITORIAL       --------------*/
    public void crearEditorialBD(Editorial e) {
        try {
            ejpa.create(e);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEditorialBD(Editorial e) {
        try {
            ejpa.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEditorialBD(String id) {
        try {
            ejpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial obtenerEditorial(String id) {
        return ejpa.findEditorial(id);
    }

    public List<Editorial> obtenerEditoriales() {
        return ejpa.findEditorialEntities();
    }

    /*  -------           CLIENTE       --------------*/
    public void crearClienteBD(Cliente c) {
        try {
            cjpa.create(c);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarClienteBD(Cliente c) {
        try {
            cjpa.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarClienteBD(Integer id) {
        try {
            cjpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente obtenerCliente(Integer id) {
        return cjpa.findCliente(id);
    }

    public List<Cliente> obtenerClientes() {
        return cjpa.findClienteEntities();
    }

    /*  -------          PRESTAMO       --------------*/
    public void crearPrestamoBD(Prestamo p) {
        try {
            pjpa.create(p);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPrestamoBD(Prestamo p) {
        try {
            pjpa.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPrestamoBD(Integer id) {
        try {
            pjpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo obtenerPrestamo(Integer id) {
        return pjpa.findPrestamo(id);
    }

    public List<Prestamo> obtenerPrestamos() {
        return pjpa.findPrestamoEntities();
    }

}
