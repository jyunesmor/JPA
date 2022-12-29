package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Cliente;
import java.util.List;
import java.util.Scanner;

public class clienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();

    public void cargarCliente() {
        Cliente c = new Cliente();
        System.out.println(" ----  Carga de Cliente  ---- ");
        System.out.println("");
        System.out.println(" ¿Cual es el Nombre del Cliente? ");
        c.setNombre(leer.next());
        System.out.println(" ¿Cual es el Apellido del Cliente? ");
        c.setApellido(leer.next());
        System.out.println(" ¿Cual es el DNI del Cliente? ");
        c.setDocumento(leer.nextLong());
        System.out.println(" ¿Cual es la Telefono del Cliente? ");
        c.setTelefono(leer.next());

        cd.crearClienteBD(c);
    }

    public void modificarCliente() {
        try {
            System.out.println(" ---  Modificacion Datos Libros  --- ");
            System.out.println("");
            mostrarClientes();
            System.out.println(" ¿ Cual Cliente desea modificar algun Dato? Ingrese su ID");
            int dni = leer.nextInt();
            Cliente c = cd.obtenerCliente(dni);
            System.out.println(c.toString());
            System.out.println("");
            boolean flag = false;
            do {
                System.out.println(" -- Menu Modificacion -- ");
                System.out.println(" ¿Cual dato desea actualizar? ");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. DNI");
                System.out.println("4. Telefono");
                System.out.println("5. Salir");
                Integer opcm = leer.nextInt();

                switch (opcm) {
                    case 1:
                        System.out.println(" ¿Ingrese el nuevo Nombre? ");
                        c.setNombre(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Ingrese el nuevo Apellido? ");
                        c.setApellido(leer.next());
                        break;
                    case 3:
                        System.out.println(" ¿Ingrese la nueva Cantidad de Ejemplares? ");
                        c.setDocumento(leer.nextLong());
                        break;
                    case 4:
                        System.out.println(" ¿Ingrese la nueva Cantidad de Ejemplares Prestados? ");
                        c.setTelefono(leer.next());
                        break;
                    case 5:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            cd.modificarClienteBD(c);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarCliente() {
        System.out.println("");
        mostrarClientes();
        System.out.println("");
        System.out.println(" ¿Cual Cliente desea eliminar? por Codigo ID? ");
        Integer id = leer.nextInt();
        cd.eliminarClienteBD(id);
    }

    public void mostrarClientes() {
        List<Cliente> liblist = cd.obtenerClientes();
        for (Cliente cl : liblist) {
            System.out.println(cl.toString());
        }
    }

    public void clientePorDNI() {
        try {
            System.out.println(" Ingrese el número de DNI que desea consultar");
            Long dni = leer.nextLong();
            List<Cliente> cl = cd.obtenerClientePorDNI(dni);
            for (Cliente c : cl) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void clientePorNombre() {
        try {
            System.out.println(" Ingrese el Nombre del Cliente que desea consultar ");
            String nombre = leer.next();
            List<Cliente> clist = cd.obtenerClientePorNombre(nombre);
            for (Cliente c : clist) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void clientePorApellido() {
        try {
            System.out.println(" Ingrese el Apellido del Cliente que desea consultar ");
            String apellido = leer.next();
            List<Cliente> clist = cd.obtenerClientePorApellido(apellido);
            for (Cliente cl : clist) {
                System.out.println(cl.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
