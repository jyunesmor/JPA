package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Autor;
import Logica.entidades.Editorial;
import Logica.entidades.Libro;
import java.util.List;
import java.util.Scanner;

public class libroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();
    autorServicio as = new autorServicio();
    editorialServicio es = new editorialServicio();

    public void cargarLibro() {
        Libro li = new Libro();
        System.out.println(" ----  Carga de Libro  ---- ");
        System.out.println("");
        System.out.println(" ¿Cual es el codigo ISBN del Libro? ");
        li.setIsbn(leer.nextLong()); 
        System.out.println(" ¿Cual es el Titulo del Libro? ");
        li.setTitulo(leer.next());
        System.out.println(" ¿Cual es el año del Libro? ");
        li.setAnio(leer.nextInt());
        System.out.println(" ¿Cual es la cantidad de Ejemplares? ");
        li.setEjemplares(leer.nextInt());
        System.out.println(" 'Cual es la cantidad de Ejemplares Prestados? ");
        li.setEjemplaresPrestados(leer.nextInt());
        System.out.println(" ¿Libro dado de Alta? ");
        li.setAlta(leer.nextBoolean());

        /* Carga Autor */
 /*  -------------------------------------------   */
        Autor a = new Autor();
        System.out.println("Listado de Autores Ingresados");
        as.mostrarAutores();
        System.out.println("");
        System.out.println("¿Se encuentra el Autor a Asignar?");
        String resp = leer.next();
        resp = resp.toLowerCase();
        if (resp.equalsIgnoreCase("s")) {
            System.out.println(" Selecciones al mismo con su Codigo");
            Integer is = leer.nextInt();
            li.setAutor(cd.obtenerAutor(is)); 
        } else {
            Autor af = as.cargarAutor();
            li.setAutor(af);
        }

        /* Carga Editorial */
 /*  -------------------------------------------   */
        Editorial e = new Editorial();
        System.out.println("Listado de Editoriales Ingresadas");
        es.mostrarEditorial();
        System.out.println("");
        System.out.println("¿Se encuentra la editorial a Asignar?");
        String respe = leer.next();
        resp = respe.toLowerCase();
        if (respe.equalsIgnoreCase("s")) {
            System.out.println(" Selecciones la misma con su Codigo");
            Integer is = leer.nextInt();
            li.setEditorial(cd.obtenerEditorial(is));
        } else {
            Editorial ed = es.cargarEditorial();
            li.setEditorial(ed);
        }
        /*  -------------------------------------------   */
        li.setEjemplaresRestantes(li.getEjemplares()-li.getEjemplaresPrestados());

        if (li == null) {
            System.out.println(" El Libro esta Vacio ");
            cargarLibro();
        } else {
            cd.crearLibroBD(li);
        }
    }

    public Libro modificarLibro() {
        try {
            System.out.println(" ---  Modificacion Datos Libros  --- ");
            System.out.println("");
            System.out.println(" ¿ Cual Libro desea modificar algun Dato? con Codigo ID");
            Integer id = leer.nextInt();
            Libro libro = cd.obtenerLibro(id);
            System.out.println("");
            boolean flag = false;
            do {
                System.out.println(" -- Menu Modificacion -- ");
                System.out.println(" ¿Cual dato desea actualizar? ");
                System.out.println("1. Nombre");
                System.out.println("2. Año");
                System.out.println("3. Cantidad Ejemplares");
                System.out.println("4. Cantidad Ejemplares Prestados");
                System.out.println("5. Alta");
                System.out.println("6. Salir");
                Integer op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println(" ¿Ingrese el nuevo Nombre? ");
                        libro.setTitulo(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Ingrese el nuevo Año? ");
                        libro.setAnio(leer.nextInt());
                        break;
                    case 3:
                        System.out.println(" ¿Ingrese la nueva Cantidad de Ejemplares? ");
                        libro.setEjemplares(leer.nextInt());
                        break;
                    case 4:
                        System.out.println(" ¿Ingrese la nueva Cantidad de Ejemplares Prestados? ");
                        libro.setEjemplaresPrestados(leer.nextInt());
                        break;
                    case 5:
                        System.out.println(" ¿Ingrese el estado del Libro? ");
                        libro.setAlta(leer.nextBoolean());
                        break;
                    case 6:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer eliminarLibro() {
        System.out.println("");
        mostrarlibros();
        System.out.println("");
        System.out.println(" ¿Cual Libro desea eliminar? por Codigo ID? ");
        Integer id = leer.nextInt();
        return id;
    }

    public void mostrarlibros() {
        List<Libro> liblist = cd.obtenerLibros();
            for (Libro libro : liblist) {
                System.out.println(libro.toString());
             } 
    }

    public void libroPorISBN() {
        try {
            System.out.println(" Ingrese el número de ISBN que desea consultar");
            Long isbn = leer.nextLong();
            List<Libro> l = cd.obtenerLibroPorISBN(isbn);
            for (Libro libro : l) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void libroPorTitulo() {
        try {
            System.out.println(" Ingrese el Titulo del Libro que desea consultar");
            String titulo = leer.next();
            List<Libro> l = cd.obtenerLibroPorTitulo(titulo);
            for (Libro libro : l) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void libroPorAutor() {
        try {
            System.out.println(" Ingrese el Nombre del Autor que desea consultar sus Libros");
            String nombre = leer.next();
            List<Libro> l = cd.obtenerLibroPorAutor(nombre);
            for (Libro libro : l) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void libroPorEditorial() {
        try {
            System.out.println(" Ingrese el Nombre de la Editorial que desea consultar sus Libros");
            String nombre = leer.next();
            List<Libro> l = cd.obtenerLibroPorEditorial(nombre);
            for (Libro libro : l) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
