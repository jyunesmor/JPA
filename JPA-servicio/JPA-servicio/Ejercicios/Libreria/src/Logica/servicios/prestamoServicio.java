package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Cliente;
import Logica.entidades.Prestamo;
import java.util.Date;
import java.util.List;

import java.util.Scanner;

public class prestamoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();
    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();
    prestamoServicio ps = new prestamoServicio();

    public Prestamo cargarprestamo() {
        Prestamo p = new Prestamo();
        System.out.println(" ----  Carga Prestamo del Libro  ---- ");
        System.out.println("");
        /*  Carga Libro  */
 /*  -------------------------------------------   */
        System.out.println(" Libros Disponibles para el prestamo ");
        System.out.println("");
        ls.mostrarlibros();
        System.out.println(" ¿Ingrese el Libro que sera prestado? por ID");
        Integer idl = leer.nextInt();
        p.setLibro(cd.obtenerLibro(idl));
        /* Carga Clientes */
 /*  -------------------------------------------   */
        System.out.println(" Clientes Disponibles para el prestamo ");
        System.out.println("");
        cs.mostrarClientes();
        System.out.println(" ¿Ingrese el Cliente que se llevara el Libro? por ID");
        Integer idc = leer.nextInt();
        Cliente c = cd.obtenerCliente(idc);
        p.setCliente(c);

        /*  -------------------------------------------   */
        System.out.println(" ¿Fecha del Prestamo? ");

        System.out.print("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.print("Ingrese el año; ");
        int anio = leer.nextInt();

        Date fp = new Date(anio - 1900, mes - 1, dia);
        p.setfPrestamo(fp);

        System.out.println(p.toString());
        return p;
    }

    public void devolverPrestamo() {
        Prestamo p = new Prestamo();

        System.out.println(" Prestamos Activos ");
        System.out.println("");
        ps.mostrarPrestamo();
        System.out.println(" ¿Ingrese el DNI del Cliente? ");
        Long dni = leer.nextLong();
        prestamosPorClientesDNI(dni);
        /*  -------------------------------------------   */
        System.out.println(" ¿Fecha de Devolución? ");

        System.out.print("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.print("Ingrese el año; ");
        int anio = leer.nextInt();

        Date fd = new Date(anio - 1900, mes - 1, dia);
        p.setDevPrestamo(fd);

        System.out.println(p.toString());

    }

    void modificarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eliminarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void menuConsultaPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarPrestamo() {
        try {
            List<Prestamo> plist = cd.obtenerPrestamos();
            for (Prestamo p : plist) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void prestamosPorClientesDNI(Long dni) {
        try {
            List<Prestamo> plist = cd.obtenerPrestamoPorNumeroDNICliente(dni);
            for (Prestamo p : plist) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
