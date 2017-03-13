/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.*;
import java.io.*;

/**
 * Version 1.0
 *
 * @author Maria Cecilia Aburto Villalobos
 */
public class ArregloInventario {
//El array se hizo estatico para que hubiera consistencia con la informacion asi como control de archivos
  public static ArrayList<Producto> p1 = new ArrayList<Producto>();
  private TecladoInventario t = new TecladoInventario();
  private Producto producto1 = new Producto();
  public static ControlArchivos arch = new ControlArchivos();

  /**
   * En este metodo se agregara un producto nuevo al inventario unidad por unidad.
   */
  public void agregarProducto() {

    Producto producto = new Producto();
    System.out.println("Ingresa la clave del producto.");
    int clave = t.leerEntero();
    if (verificarExistenciaPorClave(clave) == false) {
      t.lineaBlanco();
      System.out.println("Ingresa el nombre del producto. ");
      String nombre = t.leerString();
      System.out.println("Ingresa descripcion del producto. ");
      String descripcion = t.leerString();
      System.out.println("Ingresa el precio de compra.");
      double precioCompra = t.leerDouble();
      t.lineaBlanco();
      System.out.println("Ingresa el numero de existencias del producto.");
      int existencia = t.leerEntero();
      t.lineaBlanco();
      System.out.println("Ingresa el tipo de unidad del producto(kg,m,cm,litro,pieza).");
      String tipo = t.leerString();
      t.lineaBlanco();
      p1.add(producto);
      //Se asignan los atributos al producto
      producto.setNombre(nombre);
      producto.setDescripcion(descripcion);
      producto.setPrecioCompra(precioCompra);
      producto.setExistencia(existencia);
      producto.setTipoUnidad(tipo);
      double precioVenta = (producto.getPrecioCompra() * 1.50);
      producto.setPrecioVenta(precioVenta);
      double precioIVA = (producto.getPrecioventa() * 1.16);
      producto.setPrecioIVA(precioIVA);
      producto.setClave(clave);
      //Se guarda en el texto
      guardarP();
      System.out.println("El producto ha sido guardado con exito.");
    } else {
      System.out.println("Lo siento. La clave ya esta registrada en otro producto. ");
    }
  }

  /**
   * Este metodo verifica si la clave es existente o no en el arreglo.
   *
   * @param clave es la clave del producto del cual se verificara si esta o no en el inventario.
   * @return un booleano true si existe el producto
   */
  public boolean verificarExistenciaPorClave(int clave) {
    Iterator<Producto> it = p1.iterator();
    while (it.hasNext()) {
      if (it.next().getClave() == clave) {
        return true;
      }
    }
    return false;
  }

  /**
   * Este metodo edita un producto del inventario.
   */
  public void editarProducto(int clave) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      if (producto1.getClave() == clave) {
        System.out.println(p1.get(i));
        menuEditar();
        int numero = t.leerEntero();
        realizarEdicion(numero);
        System.out.println(p1.get(i));
        System.out.println("El objeto ha sido modificado.");
      }else{
        System.out.println("La clave no se encuentra en el inventario.");
        break;
      }
    }
  }

  /**
   * Este metodo compara los nombres de atributos con el atributo a modificar.
   *
   * @param atributo
   */
  public void menuEditar() {
    System.out.println("Selecciona el atributo que deseas modificar: ");
    System.out.println("1) Nombre");
    System.out.println("2) Descripcion");
    System.out.println("3) Precio Compra");
    System.out.println("4) Tipo unidad");
  }

  /**
   * Este metodo permite realizar una accion del menu para editar atributos
   *
   * @param numero
   */
  public void realizarEdicion(int numero) {
    switch (numero) {
      case 1:
        System.out.println("Ingresa el nuevo nombre del producto.");
        t.lineaBlanco();
        String nombre = t.leerString();
        producto1.setNombre(nombre);
        guardarP();
        break;
      case 2:
        System.out.println("Ingresa la nueva descripcion del producto.");
        t.lineaBlanco();
        String descripcion = t.leerString();
        producto1.setDescripcion(descripcion);
        guardarP();
        break;
      case 3:
        System.out.println("Ingresa el nuevo precio compra.");
        t.lineaBlanco();
        double precioCompra = t.leerDouble();
        producto1.setPrecioCompra(precioCompra);
        double precioVenta = (producto1.getPrecioCompra() * 1.50);
        producto1.setPrecioVenta(precioVenta);
        double precioIVA = (producto1.getPrecioventa() * 1.16);
        producto1.setPrecioIVA(precioIVA);
        guardarP();
        break;
      case 4:
        System.out.println("Ingresa el nuevo numero de existencias del producto.");
        t.lineaBlanco();
        int existencia = t.leerEntero();
        producto1.setExistencia(existencia);
        guardarP();
        break;
      default:
        System.out.println("El numero ingresado no es valido.");
    }
  }

  /**
   * Este metodo es para buscar un producto por nombre.
   * @param nombre del producto a buscar
   */
  public void mostrarPorNombre(String nombre) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      //Aqui se utiliza equals porqe es string
      if (producto1.getNombre().equalsIgnoreCase(nombre) ) {
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo muestra un producto por descripcion
   * @param descripcion del producto a buscar
   */
  public void mostrarPorDescripcion(String descripcion) {
    for (int i = 0; i < p1.size(); i++) {
      producto1=p1.get(i);
      if(producto1.getDescripcion().equalsIgnoreCase(descripcion)){
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo muestra un producto por clave.
   */
  public void mostrarPorClave(int clave) {
    for (int i = 0; i < p1.size(); i++) {
      producto1=p1.get(i);
      if (producto1.getClave() == clave){
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo ordenara por clave el inventario
   */
  public void ordenarClave(){
    
  }
  
  /**
   * Este metodo ordenara por nombre el inventario
   */
  public void ordenarNombre(){
    
  }
  
  /**
   * Este metodo ordenara inventario por precio
   */
  public void ordenarPrecio(){
    
  }
  
  /**
   * Este metodo es para mostrar el arreglo completo
   */
  public static void imprimirArreglo() {
    for (int i = 0; i < p1.size(); i++) {
      System.out.println(p1.get(i));
    }
  }
  
 /**
  * Este metodo eliminara un objeto del array
  * @param clave indicara la clave del objeto a eliminar
  */
  public void eliminarElemento(int clave){
    for(int i=0;i<p1.size();i++){
       producto1=p1.get(i);
       if(producto1.getClave()==clave){
         p1.remove(i);
         //ver si debo agregar otro array e ir guardando la informacion
         //guardarP();
         System.out.println("El producto ha sido eliminado con exito ");
       }else{
         System.out.println("La clave no esta en el inventario.");
         break;
       }
    }
    imprimirArreglo();
  }

  /**
   * Este metodo es para cargar los datos del array
   * Se hizo estatico porque creaba problemas de arrays vacios y por lo tanto no guardaba nada
   */
  public static void cargarP() {
    p1 = arch.recuperarDatosP();
  }

  /**
   * Este metodo es guardar los cambios al array
   * Se hizo estatico porque creaba problemas de arrays vacios y por lo tanto no guardaba nada
   */
  public static void guardarP() {
    arch.guardarObjetoP();
  }

}
