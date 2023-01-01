package Logica.Main;

import Logica.DAO.AutorDAO;
import Logica.DAO.ControlDAO;
import Logica.DAO.EditorialDAO;
import Logica.DAO.LibroDAO;
import Logica.DAO.PrestamoDAO;
import java.util.Scanner;
import Logica.entidades.Autor;
import Logica.entidades.Editorial;
import Logica.entidades.Libro;
import Logica.entidades.Prestamo;
import Logica.servicios.autorServicio;
import Logica.servicios.clienteServicio;
import Logica.servicios.editorialServicio;
import Logica.servicios.libroServicio;
import Logica.servicios.prestamoServicio;


public class Main_Prueba {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorDAO ad = new AutorDAO();
        EditorialDAO ed = new EditorialDAO();
        LibroDAO ld = new LibroDAO();
        PrestamoDAO pd = new PrestamoDAO();
        ControlDAO cd = new ControlDAO();
        editorialServicio es = new editorialServicio();
        autorServicio as = new autorServicio();
        libroServicio ls = new libroServicio();
        clienteServicio cs = new clienteServicio();
        prestamoServicio ps = new prestamoServicio();
        
        
//        ls.mostrarlibros();
//        ls.cargarLibro();
//        Integer id = ls.eliminarLibro();
//        ld.eliminarLibro(id);
//        cs.cargarCliente();
//        cs.mostrarClientes();
//        as.cargarAutor();
        Prestamo p = ps.cargarprestamo();
        cd.crearPrestamoBD(p);
//        ps.devolverPrestamo();
    }

}
