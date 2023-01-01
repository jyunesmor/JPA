package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Cliente;
import Logica.entidades.Libro;
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

    public Prestamo modificarPrestamo() {
        try {

            System.out.println(" ---  Modificacion Datos Libros  --- ");
            System.out.println("");
            System.out.println(" ¿ Cual Prestamo desea modificar algun Dato? con Codigo ID");
            Integer id = leer.nextInt();
            Prestamo p = cd.obtenerPrestamo(id);
            System.out.println("");
            boolean flag = false;
            do {
                System.out.println(" -- Menu Modificacion -- ");
                System.out.println(" ¿Cual dato desea actualizar? ");
                System.out.println("1. Libro");
                System.out.println("2. Cliente");
                System.out.println("3. Salir");
                Integer op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println(" ¿Ingrese el nuevo libro? ");
                        ls.mostrarlibros();
                        System.out.println(" ¿ Cual Libro desea Asignar? con Codigo ID");
                        Integer idl = leer.nextInt();
                        Libro l = cd.obtenerLibro(idl);
                        p.setLibro(l);
                        break;
                    case 2:
                        System.out.println(" ¿Ingrese el nuevo Cliente? ");
                        cs.mostrarClientes();
                        System.out.println(" ¿ Cual Cliente desea Asignar? con Codigo ID");
                        Integer idc = leer.nextInt();
                        Cliente c = cd.obtenerCliente(idc);
                        p.setCliente(c);
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            return p;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer eliminarPrestamo() {
        System.out.println("");
        mostrarPrestamo();
        System.out.println("");
        System.out.println(" ¿Cual Prestamo desea eliminar? por Codigo ID? ");
        Integer id = leer.nextInt();
        return id;
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
