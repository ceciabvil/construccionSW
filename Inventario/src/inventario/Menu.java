/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.*;

/**
 * version 1.0
 *
 * @author Maria cecilia Aburto Villalobos
 */
public class Menu {

  /**
   * Este metodo imprime un menu en pantalla donde te muestra las opciones a realizar
   */
  public void menuUsuario() {
    System.out.println("~~ Inventario Ferreteria~~");
    System.out.println(" Ingrese en teclado el numero de accion a realizar: ");
    System.out.println(" 1) Agregar Producto. ");
    System.out.println(" 2) Registar venta de producto");
    System.out.println(" 3) Editar un producto ");
    System.out.println(" 4) Buscar producto. ");
    System.out.println(" 5) Mostrar inventario.");
    System.out.println(" 6) Mostrar ventas de producto.");
    System.out.println(" 7) Eliminar un producto del inventario.");
    System.out.println(" 8) Salir");
  }

  /**
   * Lee las opciones que ingrese el usuario
   *
   * @return numero entero.
   */
  public int leerOpcion() {
    TecladoInventario t = new TecladoInventario();
    int a = t.leerEntero();
    return a;
  }

  /**
   * Este metodo agregara o mostrara
   *
   * @param op es la variable que eligira si mostrar o cambiar alguna información
   */
  public void realizarOpcion(int op) {
    TecladoInventario t = new TecladoInventario();
    ArregloInventario a = new ArregloInventario();
    Producto producto2 = new Producto();
    int num = 0;
    String cadena = " ";
    switch (op) {
      case 1:
        a.agregarProducto();
        break;
      case 2:
        
        break;
      case 3:
        System.out.println("Ingresa la clave del producto que deseas modificar: ");
        try {
          num = t.leerEntero();
          a.editarProducto(num);
        } catch (InputMismatchException ex) {
          System.out.println("Elemento no valido.");
        }
        break;
      case 4:
        System.out.println("1) Buscar producto por clave.");
        System.out.println("2) Buscar producto por nombre.");
        System.out.println("3) Buscar producto por descripcion.");
        try {
          num = t.leerEntero();
          if (num == 1) {
            System.out.println("Ingresa la clave del producto: ");
            t.lineaBlanco();
            num = t.leerEntero();
            a.mostrarPorClave(num);
          } else if (num == 2) {
            System.out.println("Ingresa el nombre del producto: ");
            t.lineaBlanco();
            cadena = t.leerString();
            a.mostrarPorNombre(cadena);
          } else if (num == 3) {
            System.out.println("Ingresa la descripcion del producto: ");
            t.lineaBlanco();
            cadena = t.leerString();
            a.mostrarPorDescripcion(cadena);
          }
        } catch (InputMismatchException ex) {
          System.out.println("Elemento no valido.");
        }
        break;
      case 5:
        System.out.println("Seleccione la opcion a realizar.");
        System.out.println("1) Inventario ordenado por clave. ");
        System.out.println("2) Inventario ordenado por nombre. ");
        System.out.println("3) Inventario ordenado por nombre.");
        try {
          num = t.leerEntero();
          if (num == 1) {
            a.ordenarClave();
          } else if (num == 2) {
            a.ordenarNombre();
          } else if (num == 3) {
            a.ordenarPrecio();
          }
        } catch (InputMismatchException ex) {
          System.out.println("Elemento no valido");
        }
        break;
      case 6:
        a.imprimirArreglo();
        break;
      case 7:
        a.imprimirArreglo();
        System.out.println("Ingrese la clave del producto a eliminar. ");
        try{
          num=t.leerEntero();
          a.eliminarElemento(num);
        }catch (InputMismatchException ex){
          System.out.println("Elemento no valido.");
        }
        break;
      case 8:

        break;
      case 9:
        break;
      default:
        System.out.println("El numero ingresado no es valido.Intentelo de nuevo.");
    }
  }
}
