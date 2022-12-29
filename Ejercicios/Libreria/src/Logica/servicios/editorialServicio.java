
package Logica.servicios;

import Logica.DAO.ControlDAO;
import Logica.entidades.Editorial;
import java.util.List;
import java.util.Scanner;


public class editorialServicio {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
       ControlDAO cd = new ControlDAO();
    
    public Editorial cargarEditorial() {
        try {
            Editorial ed = new Editorial();
            System.out.println(" ----  Carga de la Editorial  ---- ");
            System.out.println("");
            System.out.println(" ¿Cual es el nombre de la Editorial? ");
            ed.setNombre(leer.next());
            System.out.println(" ¿Autor dado de Alta? ");
            ed.setAlta(leer.nextBoolean());
            cd.crearEditorialBD(ed);
            return ed;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarEditorial() {
        try {
            System.out.println(" ---  Modificacion Datos Autor  --- ".toUpperCase());
            System.out.println("");
            mostrarEditorial();
            System.out.println("");
            System.out.println(" ¿ De cual Autor desea modificar algun Dato? con Codigo ID");
            Integer id = leer.nextInt();
            Editorial ed = cd.obtenerEditorial(id);
            System.out.println(ed.toString());
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
                        ed.setNombre(leer.next());
                        break;
                    case 2:
                        System.out.println(" ¿Alta o Baja? True or False ");
                        ed.setAlta(leer.nextBoolean());
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        System.out.println(" Ingreso una opcion incorrecta, por favor Ingresla nuevamente");
                }
            } while (flag != true);
            cd.modificarEditorialBD(ed);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarEditorial() {
        System.out.println("");
        mostrarEditorial();
        System.out.println("");
        System.out.println(" ¿Cual Editorial desea eliminar? por Codigo ID? ");
        Integer id = leer.nextInt();
        cd.eliminarEditorialBD(id);
    }

    void mostrarEditorial() {
        List<Editorial> liblist = cd.obtenerEditoriales();
        for (Editorial ed : liblist) {
            System.out.println(ed.toString());
        }
    }

    void consultarAutorPorNombre() {
        try {
            System.out.println(" Ingrese el Nombre de la Editorial que desea consultar");
            String titulo = leer.next();
            List<Editorial> elist = cd.obtenerEditorialPorNombre(titulo);
            for (Editorial ed : elist) {
                System.out.println(ed.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
