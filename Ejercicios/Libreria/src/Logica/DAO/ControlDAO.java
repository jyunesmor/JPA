package Logica.DAO;

import Logica.entidades.Autor;
import Logica.entidades.Cliente;
import Logica.entidades.Editorial;
import Logica.entidades.Libro;
import Logica.entidades.Prestamo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void eliminarAutor(Integer id) {
        try {
            ad.eliminarAutorPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor obtenerAutor(Integer id) {
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

    public void eliminarLibroBD(Integer id) {
        try {
            ld.eliminarLibro(id);
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

    public List<Libro> obtenerLibroPorISBN(Long isbn) {
        List<Libro> libro = new ArrayList<>();
        try {
            libro = ld.buscarLibroPorISBN(isbn);
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

    public void eliminarEditorialBD(Integer id) {
        try {
            ed.eliminarEditorial(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial obtenerEditorial(Integer id) {
        return ed.obtenerEditorial(id);
    }

    public List<Editorial> obtenerEditoriales() {
        return ed.obtenerEditoriales();
    }

    public List<Editorial> obtenerEditorialPorNombre(String nombre) {
        try {
            return ed.buscarEditorialPorTitulo(nombre);
        } catch (Exception e) {
            throw e;
        }
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
            Cliente c = obtenerCliente(id);
            cd.eliminarCliente(c);
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

    public List<Cliente> obtenerClientePorDNI(Long dni) {
        return cd.obtenerClientePorDNI(dni);
    }

    public List<Cliente> obtenerClientePorNombre(String nombre) {
        return cd.obtenerClientePorNombre(nombre);
    }

    public List<Cliente> obtenerClientePorApellido(String apellido) {
        return cd.obtenerClientePorApellido(apellido);
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
