/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import com.mysql.jdbc.exceptions.MySQLDataException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.persistence.ManyToOne;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDao;

/**
 * ----Esta clase tiene la responsabilidad de llevar adelante las
 * funcionalidades necesarias para administrar libros (consulta, creación,
 * modificación y eliminación).--- NO OLVIDAR!!!
 *
 * @author Diego
 */
public class LibroServicio {

    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private final LibroDao DAO;

    public LibroServicio() {
        this.DAO = new LibroDao();
    }

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Boolean validarSi() throws Exception {
        try {
            String si;
            do {
                si = leer.next().toUpperCase();
            } while (!si.equals("S") && !si.equals("N"));
            return (si.equals("S"));
        } catch (Exception e) {
            System.out.println("ERROR - " + e.getMessage());
            return validarSi();
        }
    }

    public void crearLibro() throws Exception {
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        EditorialServicio editorialServicio = new EditorialServicio();
        AutorServicio autorServicio;
        autorServicio = new AutorServicio();
        Libro libro = new Libro();
        Integer opcionAutor = 0;
        Integer opcionEditorial = 0;
        try {
            try {
                System.out.print("Ingrese número de ISBN: ");
                libro.setISBN(leer.nextLong());
                System.out.print("Ingrese el título del libro: ");
                libro.setTitulo(leer.next().toUpperCase());
                System.out.print("Ingrese el año de edición: ");
                libro.setAnio(leer.nextInt());
                System.out.print("Ingrese la cantidad de ejemplares: ");
                Integer ejemplares = leer.nextInt();
                libro.setEjemplares(ejemplares);
                libro.setEjemplaresPrestados(0);
                libro.setEjemplaresRestantes(ejemplares);
                List<Autor> autores = autorServicio.listaDeAutores();
                if (autores.size() != 0) {
                    for (Autor ListaAutores : autores) {
                        System.out.println(ListaAutores);
                    }
                    System.out.println("Se encuentra el autor en esta lista? S/N");
                    Boolean opcionListado = validarSi();
                    if (opcionListado) {
                        System.out.println("Ingrese el número del Autor del listado siguiente");
                        opcionAutor = leer.nextInt();
                        autor = autorServicio.buscarAutor(opcionAutor);
                        libro.setAutor(autor);
                    } else {
                        autor = autorServicio.crearAutor();
                        libro.setAutor(autor);
                    }
                } else {
                    autor = autorServicio.crearAutor();
                    libro.setAutor(autor);
                }
                List<Editorial> editoriales = editorialServicio.listaDeEditoriales();
                if (editoriales.size() != 0) {
                    for (Editorial ListaEditorial : editoriales) {
                        System.out.println(ListaEditorial);
                    }
                    System.out.println("Se encuentra el autor en esta lista? S/N");
                    Boolean opcionListado = validarSi();
                    if (opcionListado) {
                        System.out.println("Ingrese el número de editorial del listado siguiente");
                        opcionEditorial = leer.nextInt();
                        editorial = editorialServicio.buscarEditorial(opcionEditorial);
                        libro.setEditorial(editorial);
                    } else {
                        editorial = editorialServicio.crearEditorial();
                        libro.setEditorial(editorial);
                    }
                } else {
                    editorial = editorialServicio.crearEditorial();
                    libro.setEditorial(editorial);
                }
            } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
                System.out.println("Ingreso de dato errónero o vacío\n"
                        + " ");
            }
            try{
            DAO.guardar(libro);
            }catch(NullPointerException e){
                e.getMessage();
            }
            System.out.println("LIBRO GUARDADO CON ÉXITO\n"
                    + " ");

        } catch (NoSuchElementException e) {
            System.out.println("Elemento vacío");
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("No se pudo guardar Libro\n"
                    + " ");
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Ingreso de dato erróneo\n"
                    + " ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se pudo guardar Libro\n"
                    + " ");
        }
    }

    public void prestamoLibro() throws Exception {
        List<Libro> listaDeLibros = DAO.listarLibros();
        Libro libro = new Libro();
        try {
            int i = 1;
            Integer indice;
            for (Libro listado : listaDeLibros) {
                System.out.println("LIBRO N° " + i + " " + listado);
                i++;
            }
            System.out.println("INDIQUE EL NUMERO DE LIBRO QUE DESEA");
            indice = leer.nextInt();
            System.out.println("USTED DESEA ESTE LIBRO?");
            System.out.println(listaDeLibros.get(indice - 1));
            System.out.println("INDICAR S/N");
            Integer cantidad = -1;
            if (validarSi()) {
                libro = numeroEjemplares(listaDeLibros.get(indice - 1), cantidad);
                DAO.editar(libro);
                System.out.println("PRÉSTAMO REALIZADO CON ÉXITO.\n"
                        + " ");
            } else {
                libro = null;
            }
        } catch (NullPointerException e) {
            System.out.println("No se puede realizar el préstamo");
        } catch (IllegalArgumentException e) {
            System.out.println("No hay ejemplares para prestar del libro.");
            prestamoLibro();
        }
    }

    public void devolucionLibro() throws Exception {
        List<Libro> listaDeLibros = DAO.listarLibrosPrestados();
        Libro libro = new Libro();
        try {
            int i = 1;
            Integer indice;
            for (Libro listado : listaDeLibros) {
                System.out.println("LIBRO N° " + i + " " + listado);
                i++;
            }
            try {
                System.out.println("INDIQUE EL NUMERO DE LIBRO QUE DEVOLVER");
                indice = leer.nextInt();
                listaDeLibros.get(indice - 1);
                System.out.println("USTED DESEA DEVOLVER ESTE LIBRO?");
                System.out.println(listaDeLibros.get(indice - 1));
                System.out.println("INDICAR S/N");
                Integer cantidad = 1;
                if (validarSi()) {
                    libro = numeroEjemplares(listaDeLibros.get(indice - 1), cantidad);
                    DAO.editar(libro);
                    System.out.println("DEVOLUCIÓN REALIZADA CON ÉXITO.\n"
                            + " ");
                } else {
                    libro = null;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("LIBRO NO ENCONTRADO: ÍNDICE INEXISTENTE\n"
                        + " ");
            }
        } catch (NullPointerException e) {
            System.out.println("No se puede realizar el préstamo");
        } catch (Exception e) {
            System.out.println("Regrese al menú para escoger otra opción.");
            e.getMessage();
        }
    }

    public void edicionLibro() throws Exception {
        List<Libro> listaTotalLibro = DAO.listarLibros();
        Libro libro = new Libro();
        Integer opcion;
        try {
            listaTotalLibro.get(0);
            int i = 1;
            Integer indice;
            for (Libro listado : listaTotalLibro) {
                System.out.println("LIBRO N° " + i + " " + listado);
                i++;
            }
            System.out.println("INDIQUE EL NUMERO DE LIBRO QUE DESEA EDITAR");
            indice = leer.nextInt();
            System.out.println("\n"
                    + listaTotalLibro.get(indice - 1));
            System.out.println("USTED DESEA EDITAR ESTE LIBRO?");
            System.out.println("INDICAR S/N");
            if (validarSi()) {
                libro = listaTotalLibro.get(indice - 1);
                System.out.println("¿QUE INFORMACIÓN DESEA MODIFICAR?\n"
                        + "1 - ISBN\n"
                        + "2 - TÍTULO DEL LIBRO\n"
                        + "3 - AÑO DE EDICIÓN\n"
                        + "4 - CANTIDAD DE EJEMPLARES\n"
                        + "5 - AUTOR\n"
                        + "6 - EDITORIAL");
                opcion = leer.nextInt();
                editaValores(libro, opcion);
            } else {
                libro = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Listado VACÍO");
        }
    }

    public void editaValores(Libro libro, Integer opcion) throws Exception {
        String nombreNuevo;
        Long ISBNNuevo;
        Integer numeroNuevo;
        try {
            switch (opcion) {
                case 1:
                    System.out.println("INGRESE EL NUEVO ISBN DEL LIBRO");
                    ISBNNuevo = leer.nextLong();
                    System.out.println("USTED DESEA CAMBIAR \n"
                            + ISBNNuevo + " POR \n"
                            + libro.getISBN() + "?");
                    if (validarSi()) {
                        libro.setISBN(ISBNNuevo);
                        DAO.editar(libro);
                        System.out.println("ISBN EDITADO \n"
                                + libro);
                    } else {
                        System.out.println("¿QUIERE COLOCAR OTRO ISBN?");
                        if (validarSi()) {
                            editaValores(libro, 1);
                        }
                    }
                    break;
                case 2:
                    System.out.println("INGRESE EL NUEVO TÍTULO DEL LIBRO");
                    nombreNuevo = leer.next();
                    System.out.println("USTED DESEA CAMBIAR \n"
                            + nombreNuevo + " POR \n"
                            + libro.getTitulo() + "?");
                    if (validarSi()) {
                        libro.setTitulo(nombreNuevo);
                        DAO.editar(libro);
                        System.out.println("TÍTULO EDITADO \n"
                                + libro);
                    } else {
                        System.out.println("¿QUIERE COLOCAR OTRO TÍTULO?");
                        if (validarSi()) {
                            editaValores(libro, 2);
                        }
                    }
                    break;
                case 3:
                    System.out.println("INGRESE EL NUEVO AÑO DE EDICIÓN DEL LIBRO");
                    numeroNuevo = leer.nextInt();
                    System.out.println("USTED DESEA CAMBIAR \n"
                            + numeroNuevo + " POR \n"
                            + libro.getAnio() + "?");
                    if (validarSi()) {
                        libro.setAnio(numeroNuevo);
                        DAO.editar(libro);
                        System.out.println("AÑO DE EDICIÓN EDITADO \n"
                                + libro);
                    } else {
                        System.out.println("¿QUIERE COLOCAR OTRO AÑO?");
                        if (validarSi()) {
                            editaValores(libro, 3);
                        }
                    }
                    break;
                case 4:
                    System.out.println("INGRESE LA NUEVA CANTIDAD DE EJEMPLARES DEL LIBRO");
                    numeroNuevo = leer.nextInt();
                    System.out.println("USTED DESEA CAMBIAR \n"
                            + numeroNuevo + " POR \n"
                            + libro.getEjemplares() + " CANTIDAD?");
                    if (validarSi()) {
                        libro.setEjemplares(numeroNuevo);
                        DAO.editar(libro);
                        System.out.println("EJEMPLARES EDITADO \n"
                                + libro);
                    } else {
                        System.out.println("¿QUIERE COLOCAR OTRA CANTIDAD?");
                        if (validarSi()) {
                            editaValores(libro, 4);
                        }
                    }
                    break;
                case 5:
                    autorServicio.editarValores();
                    break;
                case 6:
                    editorialServicio.editarValores();
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR EN LA EDICION DE DATOS \n"
                    + e.getMessage());
        }
    }

    public void bajaDeLibro() throws Exception {
        List<Libro> listaDeLibros = DAO.listarLibrosAlta();
        Libro libro = new Libro();
        try {
            listaDeLibros.get(0);
            int i = 1;
            Integer indice;
            for (Libro listado : listaDeLibros) {
                System.out.println("LIBRO N° " + i + " " + listado);
                i++;
            }
            System.out.println("INDIQUE EL NUMERO DE LIBRO QUE DESEA DAR DE BAJA");
            indice = leer.nextInt();
            System.out.println("\n"
                    + listaDeLibros.get(indice - 1));
            System.out.println("USTED DESEA DAR DE BAJA ESTE LIBRO?");
            System.out.println("INDICAR S/N");
            if (validarSi()) {
                libro = listaDeLibros.get(indice - 1);
                libro.setAlta(Boolean.FALSE);
                DAO.editar(libro);
                System.out.println("BAJA REALIZADA CON ÉXITO.\n"
                        + " ");
            } else {
                libro = null;
            }
        } catch (NullPointerException e) {
            System.out.println("No se puede realizar baja");
        } catch (IllegalArgumentException e) {
            System.out.println("No se puede realizar la operación.");
            bajaDeLibro();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Opción no existente.");
            bajaDeLibro();
        }
    }

    public void altaDeLibro() throws Exception {
        List<Libro> listaDeLibros = DAO.listarLibrosBaja();
        Libro libro = new Libro();
        try {
            listaDeLibros.get(0);//si el listado está vacío saldra del try-catch
            int i = 1;
            Integer indice;
            for (Libro listado : listaDeLibros) {
                System.out.println("LIBRO N° " + i + " " + listado.toString());
                i++;
            }
            System.out.println("INDIQUE EL NUMERO DE LIBRO QUE DESEA DAR DE ALTA");
            indice = leer.nextInt();
            System.out.println("USTED DESEA DAR DE ALTA ESTE LIBRO?");
            System.out.println(listaDeLibros.get(indice - 1));
            System.out.println("INDICAR S/N");
            if (validarSi()) {
                libro = listaDeLibros.get(indice - 1);
                libro.setAlta(Boolean.TRUE);
                DAO.editar(libro);
                System.out.println("ALTA REALIZADA CON ÉXITO.\n"
                        + " ");
            } else {
                libro = null;
            }
        } catch (NullPointerException e) {
            System.out.println("No se puede realizar baja");
        } catch (IllegalArgumentException e) {
            System.out.println("No se puede realizar la operación.");
            bajaDeLibro();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No existen elementos en el listado");
            throw e;
        }
    }

    public Libro numeroEjemplares(Libro libroUsado, Integer cantidad) throws Exception {
        Integer EjemplaresRestantes;
        try {
            if (libroUsado.getEjemplaresRestantes() > 0) {
                EjemplaresRestantes = libroUsado.getEjemplaresRestantes() + cantidad;
                libroUsado.setEjemplaresRestantes(EjemplaresRestantes);
                libroUsado.setEjemplaresPrestados(libroUsado.getEjemplares() - EjemplaresRestantes);
                return libroUsado;
            } else if (libroUsado.getEjemplaresRestantes() == 0 && cantidad > 0) {
                EjemplaresRestantes = libroUsado.getEjemplaresRestantes() + cantidad;
                libroUsado.setEjemplaresRestantes(EjemplaresRestantes);
                libroUsado.setEjemplaresPrestados(libroUsado.getEjemplares() - EjemplaresRestantes);
                return libroUsado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("ERROR EN LOS EJEMPLARES RESTANTES");
            e.getMessage();
            return null;
        }

    }

    public void buscarLibro() throws Exception {
        List<Libro> listaBusqueda = new ArrayList<Libro>();
        Integer OPCION;
        String dato;
        try {
            System.out.println("ELIJA LA OPCIÓN QUE DESEA:\n"
                    + "1 - BUSCAR POR ISBN\n"
                    + "2 - BUSCAR POR TÍTULO DE LIBRO\n"
                    + "3 - BUSCAR POR NOMBRE DE AUTOR\n"
                    + "4 - BUSCAR POR NOMBRE DE EDITORIAL\n"
                    + "-");
            OPCION = leer.nextInt();
            switch (OPCION) {
                case 1:
                    System.out.println("Ingrese el ISBNN (o fragmento de número) a buscar:");
                    break;
                case 2:
                    System.out.println("Ingrese el Título (o parte) a buscar");
                    break;
                case 3:
                    System.out.println("Ingrese el autor (o fragmento del nombre) a buscar");
                    break;
                case 4:
                    System.out.println("Ingrese la editorial (o fragmento del nombre) a buscar");
                    break;
            }
            dato = leer.next();
            listaBusqueda = DAO.buscarLibro(OPCION, dato);
            System.out.println("ESTA ES LA LISTA DE LA BÚSQUEDA");
            for (Libro libro : listaBusqueda) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.out.println("NO SE PUDO BUSCAR LIBRO " + e.getMessage());
        }
    }
}
