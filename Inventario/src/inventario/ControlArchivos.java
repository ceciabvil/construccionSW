/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;
import java.io.*;
import java.util.*;
/**
 *Version 1.0 
 * @author Maria Cecilia Aburto Villalobos
 */
public class ControlArchivos {
  
  public static ArrayList<Producto> p1=new ArrayList<Producto>();
  
    /**
   * Este metodo guardara el array list en el objeto.
   */
  
  public static void guardarObjetoP(){
    //Se esta escribiendo el array en el archivo.
    try{
      FileOutputStream fos=new FileOutputStream("arch.txt");
      ObjectOutputStream oos=new ObjectOutputStream(fos);
      oos.writeObject(p1);
      oos.close();
      fos.close();
    }catch(java.io.IOException e){
      System.out.println("Error al escribir.");
    }
  }
  //Hacer metodo que si el arreglo esta null le añada la clave 1 y despues se vaya al ultimo lugar del arreglo obtenga la clave
  //Y le añada 1
  /**
   * Esta clase cargara el array list al programa.
   */
  public static ArrayList recuperarDatosP(){
    try{
    ObjectInputStream in=new ObjectInputStream(new FileInputStream("arch.txt"));
    p1=(ArrayList<Producto>)in.readObject();
    in.close();
  }catch(java.io.IOException|ClassNotFoundException e){
    System.out.println("Error al recuperar");
  }
  return p1;
}

}
