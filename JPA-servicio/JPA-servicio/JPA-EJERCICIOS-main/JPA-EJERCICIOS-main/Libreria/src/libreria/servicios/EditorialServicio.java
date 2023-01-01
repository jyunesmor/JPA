/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDao;

/**
 * ----Esta clase tiene la responsabilidad de llevar adelante las
 * funcionalidades necesarias para administrar editoriales (consulta, creación,
 * modificación y eliminación).--- NO OLVIDAR!!!
 *
 * @author Diego
 */
public class EditorialServicio {
    
    private LibroServicio libroServicio;
    private final EditorialDao DAO;

    public EditorialServicio() {
        this.DAO = new EditorialDao();
    }

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Editorial crearEditorial() throws Exception {
        System.out.print("Ingrese el nombre del editorial: ");
        String nombre = leer.next().toUpperCase();
        Editorial editorial = new Editorial(nombre, Boolean.TRUE);
        DAO.guardar(editorial);
        return editorial;
    }

    public List<Editorial> listaDeEditoriales() throws Exception {
        try {
            return DAO.listarEditoriales();
        } catch (NullPointerException ea) {
            System.out.println("No existen editoriales cargadas. Ingrese la primer editorial.");
            ea.getStackTrace();
            return null;
        }
    }

    public Editorial buscarEditorial(Integer id) throws Exception {
        try {
            return DAO.SeleccionEditorial(id);
        } catch (NullPointerException ee) {

            System.out.println("Se encontró un error en la selección de editorial tipo - " + ee.getMessage());
            return null;
        }

    }
    
    public void editarValores() throws Exception {
        Editorial editorial = new Editorial();
        String nombreNuevo;
        try {
            System.out.println("INGRESE EL NUEVO NOMBRE DEL AUTOR");
            nombreNuevo = leer.next();
            System.out.println("USTED DESEA CAMBIAR \n"
                    + nombreNuevo + " POR \n"
                    + editorial.getNombre() + "?");
            if (libroServicio.validarSi()) {
                editorial.setNombre(nombreNuevo);
                DAO.editar(editorial);
                System.out.println("EDITORIAL EDITADA \n"
                        + editorial);
            } else {
                System.out.println("¿QUIERE COLOCAR OTRO NOMBRE DE EDITORIAL?");
                if (libroServicio.validarSi()) {
                    editarValores();
                }
            }
        } catch (Exception e) {
        }
    }

}
