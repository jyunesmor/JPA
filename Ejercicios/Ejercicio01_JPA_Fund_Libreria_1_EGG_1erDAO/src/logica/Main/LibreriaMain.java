package logica.Main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Dominio.Autor;
import logica.Dominio.Libro;
import logica.Servicio.libroServicio;
import logica.Servicio.mainServicio;
import logica.persistencia.ControlDAO;

public class LibreriaMain {

    public static void main(String[] args) throws Exception {

        libroServicio ls = new libroServicio();
        ControlDAO cd = new ControlDAO();

//        ls.mostrarLibros();
//        ls.buscarLibroPorCodigo();
//        ls.buscarLibroPorAutor();
//        ls.buscarLibroPorEditorial();
    ls.eliminarLibro();
    }
  
   

    
    
}
