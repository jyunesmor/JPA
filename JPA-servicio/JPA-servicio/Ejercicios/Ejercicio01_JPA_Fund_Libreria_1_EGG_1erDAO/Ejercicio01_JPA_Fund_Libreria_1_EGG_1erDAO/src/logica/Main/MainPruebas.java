
package logica.Main;

import logica.Servicio.AutorServicio;
import logica.Servicio.clienteServicio;
import logica.Servicio.editorialServicio;
import logica.Servicio.libroServicio;
import logica.Servicio.prestamoServicio;

public class MainPruebas {

    public static void main(String[] args) throws Exception {
        editorialServicio es = new editorialServicio();
        libroServicio ls = new libroServicio();
        AutorServicio as = new AutorServicio();
        clienteServicio cs = new clienteServicio();
        prestamoServicio ps = new prestamoServicio();
        
        es.crearEditorialBD();
//        as.crearAutorBD(); 

        
        
    }
    
}
