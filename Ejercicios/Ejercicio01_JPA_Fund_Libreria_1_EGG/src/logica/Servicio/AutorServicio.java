package logica.Servicio;

import logica.Dominio.Autor;
import java.util.List;
import java.util.Scanner;
import logica.persistencia.AutorDAO;

public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO ad = new AutorDAO();
    
    public Autor cargaAutor() throws Exception {
        try {
            System.out.println(" ----  Carga del Autor  ---- ");
            System.out.println("");
            System.out.println(" ¿Cual es codigo de Autor? ");
            Long id = leer.nextLong();
            System.out.println(" ¿Cual es el nombre del Autor? ");
            String nombre = leer.next();
            System.out.println(" ¿Autor dado de Alta? ");
            Boolean alta = leer.nextBoolean();

            Autor a = new Autor(id, nombre, alta);
            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void crearAutorBD() throws Exception {
        try {
            Autor a = cargaAutor();
            ad.crearAutorBD(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAutor() throws Exception {
        System.out.println("");
        mostrarAutor();
        System.out.println("");
        System.out.println(" ¿ Cual es la Editor desea eliminar? por Codigo ISBN");
        Long id = leer.nextLong();
        ad.eliminarAutorPorId(id);
    }

    public void mostrarAutor() {
        List<Autor> liblist = ad.obtenerAutores();
        for (Autor au : liblist) {
            System.out.println(au.toString());
        }
    }

    public Autor obtenerAutor(Long id) {
        Autor autor = ad.obtenerAutor(id);
        return autor;
    }

    public Autor ModificarAutor() {
        try {
            System.out.println(" ---  Modificacion Datos Editorial  --- ".toUpperCase());
            System.out.println("");
            mostrarAutor();
            System.out.println("");
            System.out.println(" ¿ De cual Editorial desea modificar algun Dato? con Codigo ID");
            Long id = leer.nextLong();
            Autor a = obtenerAutor(id);
            System.out.println(a.toString());
            System.out.println("");
            boolean flag = false;
            do {
                System.out.println(" -- Menu Modificacion -- ".toUpperCase());
                System.out.println(" ¿Cual dato desea actualizar? ");
                System.out.println("1. Nombre");
                System.out.println("2. Alta");
                System.out.println("3. Salir");
                Integer op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println(" ¿Ingrese el nuevo Nombre? ");
                        a.setNombre(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Alta o Baja? True or False ");
                        a.setAlta(leer.nextBoolean());
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAutor() throws Exception {
        try {
            Autor a = ModificarAutor();
            ad.modificarAutor(a);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarAutorNombre() throws Exception{
        System.out.println("¿Ingrese el Nombre del Autor a encontrar?");
        String nombre = leer.nextLine();
        List <Autor> a = ad.buscarAutorPorNombre(nombre);
        for (Autor autor : a) {
            System.out.println(autor.toString());
        }
    }

    void consultarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
