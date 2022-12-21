package logica.Servicio;

import logica.Dominio.Cliente;
import logica.Persistencia.ClienteJpaController;
import logica.Persistencia.controlPersistencia;
import java.util.List;
import java.util.Scanner;

public class clienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    controlPersistencia cp = new controlPersistencia();

    /* Crear y Cargar Cliente dentro de Carga Libro*/
    public Cliente crearCliente() throws Exception {
        try {
            System.out.println(" ---  Carga Cliente  --- ".toUpperCase());
            System.out.println("");
            System.out.println("Ingrese el Id del Cliente");
            Integer id = leer.nextInt();
            System.out.println("Ingrese el documento del Cliente");
            Long documento = leer.nextLong();
            System.out.println("Ingrese el Nombre del Cliente");
            String nombre = leer.next();
            System.out.println("Ingrese el Apellido del Cliente");
            String apellido = leer.next();
            System.out.println("Ingrese el Telefono del Cliente");
            String telefono = leer.next();
            Cliente c = new Cliente(id, documento, nombre, apellido, telefono);
            cp.crearClienteBD(c);
            return c;
        } catch (Exception e) {
            throw e;
        }
    }

    /* Crear y Cargar Cliente nuevo*/ 
    public void crearClienteBD() throws Exception {
        try {
            Cliente c = crearCliente();
            cp.crearClienteBD(c);
        } catch (Exception e) {
            throw e;
        }
    }

    /* Mostrar Clientes*/ 
    public void mostrarClientes() {
        List<Cliente> clist = cp.obtenerClientes();
        for (Cliente c : clist) {
            System.out.println(c.toString());
        }
    }

    /* Obtener Cliente deseado*/ 
    public Cliente obtenercliente(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("No ingreso ningun ID");
            }
            Cliente c = cp.obtenerCliente(id);
            return c;
        } catch (Exception e) {
            throw e;
        }
    }

    void modificarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eliminarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void consultarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
