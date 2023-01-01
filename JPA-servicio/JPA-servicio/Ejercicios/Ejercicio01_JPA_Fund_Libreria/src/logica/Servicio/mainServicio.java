package logica.Servicio;

import java.util.Scanner;

public class mainServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    editorialServicio es = new editorialServicio();
    autorServicio as = new autorServicio();
    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();
    prestamoServicio ps = new prestamoServicio();

    public void menuPrincipal() throws Exception {
        boolean flagmenu = false;
        do {
            System.out.println(" ----  Menu Carga ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Libro");
            System.out.println("2. Autor");
            System.out.println("3. Editorial");
            System.out.println("4. Cliente");
            System.out.println("5. Prestamo");
            System.out.println("6. Salir");
            Integer opm = leer.nextInt();

            switch (opm) {
                case 1:
                    menuLibro();
                    break;
                case 2:
                    menuLibro();
                    break;
                case 3:
                    menuAutor();
                    break;
                case 4:
                    menuCliente();
                    break;
                case 5:
                    menuPrestamo();
                    break;
                case 6:
                    flagmenu = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagmenu != true);
    }

    public void menuLibro() throws Exception {
        boolean flaglibro = false;
        do {
            System.out.println(" ----  Menu Libro ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Cargar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            Integer opl = leer.nextInt();

            switch (opl) {
                case 1:
                    ls.crearLibro();
                    break;
                case 2:
                    ls.modificarLibro();
                    break;
                case 3:
                    ls.eliminarLibro();
                    break;
                case 4:
                    ls.consultarLibro();
                    break;
                case 5:
                    flaglibro = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flaglibro != true);
    }

    public void menuAutor() throws Exception {
        boolean flagAu = false;
        do {
            System.out.println(" ----  Menu Autor ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Cargar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            Integer opa = leer.nextInt();

            switch (opa) {
                case 1:
                    as.crearAutorBD();
                    break;
                case 2:
                    as.modificarAutor();
                    break;
                case 3:
                    as.eliminarAutor();
                    break;
                case 4:
                    as.consultarAutor();
                    break;
                case 5:
                    flagAu = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagAu != true);
    }

    public void menuEditorial() throws Exception {
        boolean flagEdi = false;
        do {
            System.out.println(" ----  Menu Editorial ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Cargar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            Integer ope = leer.nextInt();

            switch (ope) {
                case 1:
                    es.crearEditorialBD();
                    break;
                case 2:
                    es.modificarEditorial();
                    break;
                case 3:
                    es.eliminarEditorial();
                    break;
                case 4:
                    es.consultarEditorial();
                    break;
                case 5:
                    flagEdi = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagEdi != true);
    }

    public void menuCliente() throws Exception {
        boolean flagcli = false;
        do {
            System.out.println(" ----  Menu Cliente ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Cargar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            Integer opc = leer.nextInt();

            switch (opc) {
                case 1:
                    cs.crearClienteBD();
                    break;
                case 2:
                    cs.modificarCliente();
                    break;
                case 3:
                    cs.eliminarCliente();
                    break;
                case 4:
                    cs.consultarCliente();
                    break;
                case 5:
                    flagcli = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagcli != true);
    }

    public void menuPrestamo() throws Exception {
        boolean flagpres = false;
        do {
            System.out.println(" ----  Menu Prestamo ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a trabajar ");
            System.out.println("1. Cargar");
            System.out.println("2. Devolver");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Consultar");
            System.out.println("6. Salir");
            Integer opp = leer.nextInt();

            switch (opp) {
                case 1:
                    ps.cargarPrestamo();
                    break;
                case 2:
                    ps.devolucionPrestamo();
                    break;
                case 3:
                    ps.modificarPrestamo();
                    break;
                case 4:
                    ps.eliminarPrestamo();
                    break;
                case 5:
                    ps.consultarPrestamo();
                    break;
                case 6:
                    flagpres = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagpres != true);
    }
}
