package logica.Servicio;

import logica.Dominio.Autor;
import logica.Dominio.Editorial;
import logica.Dominio.Libro;

import java.util.List;
import java.util.Scanner;

import logica.persistencia.ControlDAO;

public class libroServicio {

    editorialServicio es = new editorialServicio();
    AutorServicio as = new AutorServicio();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControlDAO cd = new ControlDAO();

    
    //  Obtenemos Libro
    public Libro cargaLibro() throws Exception {

        System.out.println(" ----  Carga de Libro  ---- ");
        System.out.println("");
        System.out.println(" ¿Cual es el Titulo del Libro? ");
        String nombre = leer.next();
        System.out.println(" ¿Cual es el año del Libro? ");
        Integer anio = leer.nextInt();
        System.out.println(" ¿Cual es la cantidad de Ejemplares? ");
        Integer ej = leer.nextInt();
        System.out.println(" 'Cual es la cantidad de Ejemplares Prestados? ");
        Integer ejp = leer.nextInt();
        System.out.println(" ¿Libro dado de Alta? ");
        Boolean alta = leer.nextBoolean();
                         /* Carga Autor */
        /*  -------------------------------------------   */
        Autor a = new Autor();
        System.out.println("Listado de Autores Ingresados");
        as.mostrarAutor();
        System.out.println("");
        System.out.println("¿Se encuentra el Autor a Asignar?");
        String resp = leer.next();
        resp = resp.toLowerCase();
        if (resp.equalsIgnoreCase("s")) {
            System.out.println(" Selecciones al mismo con su Codigo");
            Long is = leer.nextLong();
            a = as.obtenerAutor(is);
        } else {
            a = as.cargaAutor();
        }
        /*  -------------------------------------------   */
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
            String is = leer.next();
            e = es.obtenerEditorial(is);
        } else {
            e = es.cargaEditorial();
        }
        /*  -------------------------------------------   */
        Integer ejr = ej - ejp;
        Libro libro = new Libro(null, nombre, anio, ej, ejp, ejr, alta, a, e);

        return libro;
    }

    //  Obtengo Libro a Modificar por su ISBN y modifico dato que deseo y lo devuelvo.
    public Libro ModificarLibro() {
        try {
            System.out.println(" ---  Modificacion Datos Libros  --- ");
            System.out.println("");
            System.out.println(" ¿ Cual Libro desea modificar algun Dato? con Codigo ISBN");
            Long isbn = leer.nextLong();
            Libro libro = cd.obtenerLibro(isbn);
            System.out.println(libro.toString());
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

    // Eliminamos por ISBN
    public void eliminarLibro() throws Exception {
        System.out.println("");
        mostrarLibros();
        System.out.println("");
        System.out.println(" ¿Cual Libro desea eliminar? por Codigo ISBN? ");
        Long isbn = leer.nextLong();
        Libro libro = cd.obtenerLibro(isbn);
        cd.eliminarLibroBD(libro);
    }

    public void mostrarLibros() {
        List<Libro> liblist = cd.obtenerLibros();
            for (Libro libro : liblist) {
                System.out.println(libro.toString());
             }
//        if (liblist.size() > 0 ) {
//            System.out.println(" Los Libros Ingresados son: ".toUpperCase());
//            for (Libro libro : liblist) {
//                System.out.println(libro.toString());
//             }
//        } else {
//            System.out.println(" No hay Libros en la Base de Datos".toUpperCase());
//        }

    }

    public void buscarLibroPorCodigo() throws Exception {
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

    public void buscarLibroPorTitulo() throws Exception {
        try {
            System.out.println(" Ingrese el Titulo del Libro que desea consultar");
            String titulo = leer.next();
            List<Libro> l = null;
            for (Libro libro : l) {
                System.out.println(libro.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarLibroPorAutor() throws Exception {
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

    public void buscarLibroPorEditorial() throws Exception {
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

    void consultarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
