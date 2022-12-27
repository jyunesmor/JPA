package logica.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logica.Dominio.Autor;
import logica.Dominio.Cliente;
import logica.Dominio.Editorial;
import logica.Dominio.Libro;
import logica.Dominio.Prestamo;

public class ControlDAO {

   
    AutorDAO ad = new AutorDAO();
    LibroDAO ld = new LibroDAO();
    EditorialDAO ed = new EditorialDAO();
    ClienteDAO cd = new ClienteDAO();
    PrestamoDAO pd = new PrestamoDAO();

    /*  ---------         AUTOR         --------------*/
    public void crearAutor(Autor a) {
        ad.crearAutorBD(a);
    }

    public void modificarAutor(Autor a) {
        try {
            ad.modificarAutor(a);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarAutor(Long id) {
        try {
            ad.eliminarAutorPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor obtenerAutor(Long id) {
        return ad.obtenerAutor(id);
    }

    public List<Autor> obtenerAutores() {
        try {
         
            return ad.obtenerAutores();
        } catch (Exception e) {
            throw e;
        } 
    }

    public List<Autor> obtenerAutorPorNombre(String nombre) {
        try {
            return ad.buscarAutorPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        } 
    }


    /*  --------          LIBRO         --------------*/
    public void crearLibroBD(Libro l) {
        try {
            ld.crearLibroBD(l);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarLibroBD(Libro l) {
        try {
            ld.modificarLibro(l);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarLibroBD(Libro libro) {
        try {
            ld.eliminarLibro(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public Libro obtenerLibro(Long id) {
        return ld.obtenerLibro(id);
    }

    public List<Libro> obtenerLibros() {
        return ld.obtenerLibros();
    }

    public List<Libro> obtenerLibroPorISBN(Long id) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ld.buscarLibroPorISBN(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    public List<Libro> obtenerLibroPorTitulo(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ld.buscarLibroPorTitulo(nombre);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    public List<Libro> obtenerLibroPorEditorial(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ld.buscarLibroPorEditorial(nombre);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    public List<Libro> obtenerLibroPorAutor(String nombre) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ld.buscarLibroPorAutor(nombre);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }


    /*  -------         EDITORIAL       --------------*/
    public void crearEditorialBD(Editorial e) {
        try {
            ed.crearEditorialBD(e);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEditorialBD(Editorial e) {
        try {
            ed.modificarEditorialBD(e);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEditorialBD(String id) {
        try {
            ed.eliminarEditorial(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial obtenerEditorial(String id) {
        return ed.obtenerEditorial(id);
    }

    public List<Editorial> obtenerEditoriales() {
        return ed.obtenerEditoriales();
    }

    /*  -------           CLIENTE       --------------*/
    public void crearClienteBD(Cliente c) {
        try {
            cd.crearClienteBD(c);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarClienteBD(Cliente c) {
        try {
            cd.modificarCliente(c);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarClienteBD(Integer id) {
        try {
            cd.eliminarCliente(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente obtenerCliente(Integer id) {
        return cd.obtenerCliente(id);
    }

    public List<Cliente> obtenerClientes() {
        return cd.obtenerClientes();
    }

    /*  -------          PRESTAMO       --------------*/
    public void crearPrestamoBD(Prestamo p) {
        try {
            pd.crearPrestamoBD(p);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPrestamoBD(Prestamo p) {
        try {
            pd.modificarPrestamo(p);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPrestamoBD(Integer id) {
        try {
            pd.eliminarPrestamo(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo obtenerPrestamo(Integer id) {
        return pd.obtenerPrestamo(id);
    }

    public List<Prestamo> obtenerPrestamos() {
        return pd.obtenerPrestamos();
    }

}
