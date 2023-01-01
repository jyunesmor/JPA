/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import java.util.InputMismatchException;

/**
 *
 * @author Diego
 */
public class Menu {

    private LibroServicio libroServicio = new LibroServicio();
    private AutorServicio autorServicio = new AutorServicio();
    private EditorialServicio editorialServicio;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void MenuPrincipal() throws Exception {
        Integer OPCION = null;
        do {
            System.out.println("POR FAVOR: INGRESE LA OPCIÓN QUE QUIERA REALIZAR: \n"
                    + "1 - INGRESAR LIBRO\n"
                    + "2 - PRESTAR LIBRO\n"
                    + "3 - DEVOLVER LIBRO\n"
                    + "4 - DAR DE ALTA/BAJA UN LIBRO\n"
                    + "5 - EDITAR LIBRO\n"
                    + "6 - BUSCAR AUTOR POR NOMBRE\n"
                    + "7 - BUSCAR LIBRO \n"
                    + "8 - SALIR"
                    + " ");
            try {
                System.out.println("Ingrese la opcion y luego presione ENTER");
                System.out.print("OPCION: ");
                OPCION = leer.nextInt();
                switch (OPCION) {
                    case 1:
                        libroServicio.crearLibro();
                        break;
                    case 2:
                        libroServicio.prestamoLibro();
                        break;
                    case 3:
                        libroServicio.devolucionLibro();
                        break;
                    case 4:
                        System.out.println("DESEA DAR : \n"
                                + "1 - ALTA DE LIBRO \n"
                                + "2 - BAJA DE LIBRO");
                        System.out.print("- ");
                        OPCION = leer.nextInt();
                        try {
                            if (OPCION == 1) {
                                libroServicio.altaDeLibro();
                            } else if (OPCION == 2) {
                                libroServicio.bajaDeLibro();
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR EN EL DATO INGRESADO " + e.getMessage());
                            MenuPrincipal();
                        }
                        break;
                    case 5:
                        libroServicio.edicionLibro();
                        break;
                    case 6:
                        autorServicio.buscarAutorNombre();
                        break;
                    case 7:
                       libroServicio.buscarLibro();
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("NUMERO DE OPCIÓN INCORRECTO\n"
                                + "INGRESE UN NUEVO NÚMERO");
                        break;
                }
            } catch (InputMismatchException num) {
                System.out.println(num.getMessage());
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        } while (OPCION < 8);

    }

    public Boolean SalirMenu() {
        String SALIR = null;
        do {
            System.out.println("¿DESEA SALIR? S/N");
            SALIR = leer.next().toUpperCase();
        } while (!SALIR.equals("S") && !SALIR.equals("N"));
        return (!"S".equals(SALIR));
    }

}
