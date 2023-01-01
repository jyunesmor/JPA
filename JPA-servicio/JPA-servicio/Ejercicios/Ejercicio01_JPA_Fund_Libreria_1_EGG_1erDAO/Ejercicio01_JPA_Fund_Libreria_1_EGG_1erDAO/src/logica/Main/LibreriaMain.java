package logica.Main;


import logica.Servicio.editorialServicio;
import logica.Servicio.libroServicio;
import logica.persistencia.ControlDAO;

public class LibreriaMain {

    public static void main(String[] args) throws Exception {

        libroServicio ls = new libroServicio();
        editorialServicio es = new editorialServicio();
        ControlDAO cd = new ControlDAO();

//        ls.mostrarLibros();
//        ls.buscarLibroPorCodigo();
//        ls.buscarLibroPorAutor();
//        ls.buscarLibroPorEditorial();
//        ls.eliminarLibro();
        ls.crearLibro();
//          es.eliminarEditorial();

    }
  
   

    
    
}
