package Logica.Main;

import Logica.DAO.AutorDAO;
import Logica.DAO.EditorialDAO;
import Logica.DAO.LibroDAO;
import java.util.Scanner;
import Logica.entidades.Autor;
import Logica.entidades.Editorial;
import Logica.entidades.Libro;
import Logica.servicios.autorServicio;
import Logica.servicios.editorialServicio;
import Logica.servicios.libroServicio;


public class Main_Prueba {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorDAO ad = new AutorDAO();
        EditorialDAO ed = new EditorialDAO();
        LibroDAO ld = new LibroDAO();
        editorialServicio es = new editorialServicio();
        autorServicio as = new autorServicio();
        libroServicio ls = new libroServicio();

//        ls.mostrarlibros();
        ls.cargarLibro();
        
        
    }

}
