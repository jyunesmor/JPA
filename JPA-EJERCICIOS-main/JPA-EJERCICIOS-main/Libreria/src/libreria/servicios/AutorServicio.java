/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDao;

/**
 * ----Esta clase tiene la responsabilidad de llevar adelante las
 * funcionalidades necesarias para administrar autores (consulta, creación,
 * modificación y eliminación).--- NO OLVIDAR!!!
 *
 * @author Diego
 */
public class AutorServicio {

    private LibroServicio libroServicio;
    private final AutorDao DAO;

    public AutorServicio() {
        this.DAO = new AutorDao();
    }

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor crearAutor() throws Exception {
        Autor autor1 = new Autor();
        try {
            System.out.print("Ingrese el nombre del Autor: ");
            autor1.setId(Integer.SIZE);
            autor1.setNombre(leer.next().toUpperCase());
            DAO.guardar(autor1);
            return autor1;
        } catch (Exception ea) {
            ea.getMessage();
            ea.printStackTrace();
            return null;
        }
    }

    public void buscarAutorNombre() throws Exception {
        List<Autor> listaBusqueda = new ArrayList<Autor>();
        String busqueda;
        try {
            System.out.println("Ingrese el nombre (o parte del nombre) del autor.");
            busqueda = leer.next();
            listaBusqueda = DAO.buscarAutores(busqueda);
            for (Autor autores : listaBusqueda) {
                System.out.println(autores);
            }
        } catch (Exception e) {
            System.out.println("NO SE PUDO BUSCAR AUTOR " + e.getMessage());
        }
    }

    public List<Autor> listaDeAutores() throws Exception {
        try {
            return DAO.listarAutores();
        } catch (NullPointerException ea) {
            System.out.println("No existen autores en la lista, ingrese al primer autor.");
            ea.getStackTrace();
            return null;
        }
    }

    public Autor buscarAutor(Integer id) throws Exception {
        try {
            return DAO.SeleccionAutor(id);
        } catch (NullPointerException ea) {

            System.out.println("Se encontró un error en la selección del autor tipo - "
                    + ea.getMessage());
            return null;
        }

    }

    public void editarValores() throws Exception {
        Autor autor = new Autor();
        String nombreNuevo;
        try {
            System.out.println("INGRESE EL NUEVO NOMBRE DEL AUTOR");
            nombreNuevo = leer.next();
            System.out.println("USTED DESEA CAMBIAR \n"
                    + nombreNuevo + " POR \n"
                    + autor.getNombre() + "?");
            if (libroServicio.validarSi()) {
                autor.setNombre(nombreNuevo);
                DAO.editar(autor);
                System.out.println("AUTOR EDITADO \n"
                        + autor);
            } else {
                System.out.println("¿QUIERE COLOCAR OTRO NOMBRE DE AUTOR?");
                if (libroServicio.validarSi()) {
                    editarValores();
                }
            }
        } catch (Exception e) {
        }
    }

}
