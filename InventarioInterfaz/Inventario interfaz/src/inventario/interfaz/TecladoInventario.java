/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.interfaz;
import java.util.*;

/**
 *Version 1.0
 * @author Maria Cecilia Aburto Villalobos
 */
public class TecladoInventario {
  private Scanner sc;
  /**
   * Es el constructor donde se inicializa la variable Scanner.
   */
  public TecladoInventario(){
    sc=new Scanner (System.in);
  }
  /**
   * En esta funcion se lee un string 
   * @return sc regresa un string
   */
  public String leerString (){
    return sc.nextLine();
  }
  /**
   * Esta funcion lee un numero entero
   * @return numero entero
   */
  public int leerEntero(){
    return sc.nextInt();
  }
  /**
   * Esta funcion lee un double 
   * @return un double
   */
  public double leerDouble(){
    return sc.nextDouble();
  }
  
  /**
   * Esta funcion permite limpiar e buffer
   */
  public String lineaBlanco(){
    return sc.nextLine();
  }
}
