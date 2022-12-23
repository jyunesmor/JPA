package logica.Main;



import logica.Servicio.autorServicio;
import logica.Servicio.clienteServicio;
import logica.Servicio.editorialServicio;
import logica.Servicio.libroServicio;
import logica.Servicio.mainServicio;
import logica.Servicio.prestamoServicio;

public class LibreriaMain {

    public static void main(String[] args) throws Exception {

        libroServicio ls = new libroServicio();
        editorialServicio es = new editorialServicio();
        autorServicio as = new autorServicio();
        mainServicio ms = new mainServicio();
        clienteServicio cs = new clienteServicio();
        prestamoServicio ps = new prestamoServicio();
        

     
                ms.menuLibro();
    }

        
}
