/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;


/**
 *
 * @author Diego
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            System.out.println("BIENVENIDO A LA LIBRERÍA DE EGG");
            Menu menu = new Menu();
            do {
                menu.MenuPrincipal();
            } while (menu.SalirMenu());
        } catch (Exception e) {
            System.out.println("ERROR EN MAIN");
        }
    }

}
