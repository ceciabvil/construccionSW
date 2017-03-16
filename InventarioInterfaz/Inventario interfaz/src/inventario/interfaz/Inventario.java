/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.interfaz;

/**
 *Version 1.0
 * @author Maria Cecilia Aburto Villalobos
 */
public class Inventario {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    
   ArregloInventario a1=new ArregloInventario();
   // a1.cargarP();
    Menu menu=new Menu();
    int op=0;
    do{
      a1.cargarP();
      a1.cargarV();
      menu.menuUsuario();
      op=menu.leerOpcion();
      menu.realizarOpcion(op);
      a1.guardarP();
      a1.guardarV();
    }while(op !=8);
  }
  
}
