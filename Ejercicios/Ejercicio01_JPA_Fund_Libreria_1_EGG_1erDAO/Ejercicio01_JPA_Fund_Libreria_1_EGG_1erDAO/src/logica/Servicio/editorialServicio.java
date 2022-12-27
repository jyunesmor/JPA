package logica.Servicio;

import logica.Dominio.Editorial;
import java.util.List;
import java.util.Scanner;
import logica.persistencia.ControlDAO;
import logica.persistencia.EditorialDAO;

public class editorialServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO ed = new EditorialDAO();

    public Editorial cargaEditorial() throws Exception {
        try {
            System.out.println(" ----  Carga de Editorial  ---- ");
            System.out.println("");
            System.out.println(" ¿Cual es el Número de Editorial? ");
            String id = leer.next();
            System.out.println(" ¿Cual es el nombre de la Editorial? ");
            String nombre = leer.next();
            System.out.println(" ¿Editorial dada de Alta? ");
            Boolean alta = leer.nextBoolean();

            Editorial e = new Editorial(id, nombre, alta);
            return e;
        } catch (Exception e) {
            throw e;
        }
    }

    public void crearEditorialBD() throws Exception {
        try {
            Editorial e = cargaEditorial();
            ed.crearEditorialBD(e);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarEditorial() throws Exception {
        System.out.println("");
        mostrarEditorial();
        System.out.println("");
        System.out.println(" ¿ Cual es la Editor desea eliminar? por Codigo ISBN");
        String id = leer.next();
        ed.eliminarEditorial(id);

    }

    public void mostrarEditorial() {
        List<Editorial> liblist = ed.obtenerEditoriales();
        for (Editorial ed : liblist) {
            System.out.println(ed.toString());
        }
    }

    public Editorial obtenerEditorial(String id) {
        Editorial editorial = ed.obtenerEditorial(id);
        return editorial;
    }

    public Editorial ModificarEditorial() {
        try {
            System.out.println(" ---  Modificacion Datos Editorial  --- ".toUpperCase());
            System.out.println("");
            mostrarEditorial();
            System.out.println("");
            System.out.println(" ¿ De cual Editorial desea modificar algun Dato? con Codigo ID");
            String id = leer.next();
            Editorial e = ed.obtenerEditorial(id);
            System.out.println(e.toString());
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
                        e.setNombre(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Alta o Baja? True or False ");
                        e.setAlta(leer.nextBoolean());
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            return e;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarEditorial() throws Exception {
        try {
            Editorial e = ModificarEditorial();
            ed.editar(e);
        } catch (Exception e) {
            throw e;
        }
    }

    void consultarEditorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
