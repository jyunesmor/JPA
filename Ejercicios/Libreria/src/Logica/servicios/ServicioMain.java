/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Autor;
import Logica.entidades.Editorial;
import Logica.entidades.Libro;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class ServicioMain {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    editorialServicio es = new editorialServicio();
    autorServicio as = new autorServicio();
    libroServicio ls = new libroServicio();
    clienteServicio cs = new clienteServicio();
    prestamoServicio ps = new prestamoServicio();
    ControlDAO cd = new ControlDAO();

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
                    menuAutor();
                    break;
                case 3:
                    menuEditorial();
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
        Libro l = null;
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
                    ls.cargarLibro();
                    break;
                case 2:
                    l = ls.modificarLibro();
                    cd.modificarLibroBD(l);
                    break;
                case 3:
                    Integer id = ls.eliminarLibro();
                    cd.eliminarLibroBD(id);
                    break;
                case 4:
                    menuConsultaLibro();
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
                    Autor a = as.cargarAutor();
                    cd.crearAutor(a);
                    break;
                case 2:
                    as.modificarAutor();
                    break;
                case 3:
                    as.eliminarAutor();
                    break;
                case 4:
                    consultarAutor();
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
                    Editorial ed = es.cargarEditorial();
                    cd.crearEditorialBD(ed);
                    break;
                case 2:
                    es.modificarEditorial();
                    break;
                case 3:
                    es.eliminarEditorial();
                    break;
                case 4:
                    consultaEditorial();
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    flagpres = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagpres != true);
    }

    private void menuConsultaLibro() {
        boolean flagCm = false;
        do {
            System.out.println(" ----  Menu Consulta Libro ---- ".toUpperCase());
            System.out.println("");
            System.out.println(" Seleccione la opcion a Consultar ");
            System.out.println("1. Consultar Libros");
            System.out.println("2. Consultar Libro por ISBN");
            System.out.println("3. Consultar Libro por Titulo");
            System.out.println("4. Consulto Libro por Autor");
            System.out.println("5. Consulto Libro por Editorial");
            System.out.println("6. Salir");
            Integer opcm = leer.nextInt();

            switch (opcm) {
                case 1:
                    ls.mostrarlibros();
                    break;
                case 2:
                    ls.libroPorISBN();
                    break;
                case 3:
                    ls.libroPorTitulo();
                    break;
                case 4:
                    ls.libroPorAutor();
                    break;
                case 5:
                    ls.libroPorEditorial();
                    break;
                case 6:
                    flagCm = true;
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta, ingrese nuevamente");
            }
        } while (flagCm != true);
    }

    private void consultarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void consultaEditorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
