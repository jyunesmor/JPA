package logica.Servicio;

import logica.Dominio.Cliente;
import logica.Dominio.Libro;
import logica.Dominio.Prestamo;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class prestamoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");


    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();

    public Prestamo generarPrestamo() throws Exception {
        try {
            /*  -------------------------------------   */
            /*  -----------    Prestamo    ----------   */
            System.out.println(" -- Iniciar Prestamo -- ".toUpperCase());
            System.out.println("");
            System.out.println("¿Ingreso el Id del Prestamo?");
            Integer id = leer.nextInt();
            System.out.println("¿Ingrese la fecha de Inicio del Prestamo?");
            int dia = leer.nextInt();
            int mes = leer.nextInt();
            int anio = leer.nextInt();
            Date fechaPrestamo = new Date(anio - 1900, mes - 1, dia);

            /*  -------------------------------------   */
            /*  -----------    LIBRO    -------------   */
            Libro l = new Libro();
            System.out.println("Listado de Libros Disponibles");
       
            System.out.println("");
            System.out.println("¿Se encuentra el Libro a prestar?");
            String resp = leer.next();
            resp = resp.toLowerCase();
            if (resp.equalsIgnoreCase("s")) {
                System.out.println(" Selecciones al mismo con su Codigo ISBN");
                Long is = leer.nextLong();
                l =  null;
                /* Ajusto la Cantidad de Ejemplares Prestados */
                if (l != null) {
                    int ejprest = l.getEjemplaresPrestados() + 1;
                    l.setEjemplaresPrestados(ejprest);
                    
                }
            } else {
                l = null;
            }
            /*  -------------------------------------   */
            /*  -----------   Cliente   -------------   */
            Cliente c = new Cliente();
            System.out.println("Listado de Autores Ingresados");
            cs.mostrarClientes();
            System.out.println("");
            System.out.println("¿Se encuentra el Cliente?");
            resp = leer.next();
            resp = resp.toLowerCase();
            if (resp.equalsIgnoreCase("s")) {
                System.out.println(" Selecciones al mismo con su Codigo ISBN");
                Long is = leer.nextLong();
                c = cs.obtenercliente(id);
            } else {
                c = cs.crearCliente();
            }
            Prestamo p = new Prestamo(id, fechaPrestamo, null, l, c);
            
            return p;
        } catch (Exception e) {
            throw e;
        }
    }

    public void devolucionPrestamo() {
        /*  ---------------------------------------   */
 /*  -----------    Devolucion    ----------   */
        System.out.println(" -- Iniciar Devolución -- ".toUpperCase());
        System.out.println(" Prestamos Otorgados ");
        obtenerPrestamosOtorgados();
        System.out.println("");
        System.out.println("¿Ingreso el Id del Prestamo?");
        Integer id = leer.nextInt();
        System.out.println("¿Ingrese la fecha de Inicio del Prestamo?");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        Date fechaPrestamo = new Date(anio - 1900, mes - 1, dia);
    }

    public void obtenerPrestamosOtorgados() {
        try {
            List<Prestamo> p = null;
            for (Prestamo pr : p) {
                if (pr.getLibro().getAlta() == true) {
                    System.out.println(pr.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

    void cargarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void consultarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eliminarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void modificarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} // Fin Public Class
