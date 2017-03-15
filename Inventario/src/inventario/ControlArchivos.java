/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.io.*;
import java.util.*;

/**
 * Version 1.0
 *
 * @author Maria Cecilia Aburto Villalobos
 */
public class ControlArchivos {

  public static ArrayList<Producto> p1 = new ArrayList<Producto>();
  public static ArrayList<Venta> arrayVenta = new ArrayList<Venta>();

  /**
   * Este metodo guardara el array list en el objeto.
   */
  public static void guardarObjetoP() {
    //Se esta escribiendo el array en el archivo.
    try {
      FileOutputStream fos = new FileOutputStream("arch.txt");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(p1);
      oos.close();
      fos.close();
    } catch (java.io.IOException e) {
      System.out.println("Error al escribir.");
    }
  }
  
  /**
   * Este metodo guardara las ventas en el arraylist correspondiente
   */
  public static void guardarVenta(){
    try{
      FileOutputStream fos=new FileOutputStream("arch2.txt");
      ObjectOutputStream oos=new ObjectOutputStream(fos);
      oos.writeObject(arrayVenta);
      oos.close();
      fos.close();
    }catch(java.io.IOException e){
      System.out.println("Error al escribir en venta.");
    }
  }

  /**
   * Este metodo cargara el array list al programa.
   */
  public static ArrayList recuperarDatosP() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("arch.txt"));
      p1 = (ArrayList<Producto>) in.readObject();
      in.close();
    } catch (java.io.IOException | ClassNotFoundException e) {
      System.out.println("Error al recuperar");
    }
    return p1;
  }

  /**
   * Este metodo cargara el arraylist de ventas al programa
   */
  public static ArrayList recuperarVenta() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("arch2.txt"));
      arrayVenta=(ArrayList<Venta>)in.readObject();
      in.close();
    } catch (java.io.IOException|ClassNotFoundException e) {
      System.out.println("Error al recuperar ventas registradas");
    }
    return arrayVenta;
  }

}
