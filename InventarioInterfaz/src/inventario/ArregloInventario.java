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
  public static ArrayList<Producto> arrayVenta = new ArrayList<Producto>();
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
      arrayVenta.add(producto);
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
      int ventaProducto = 0;
      producto.setVentaProducto(ventaProducto);
      double precioTotalVenta=0;
      producto.setPrecioTotalVendido(precioTotalVenta);
      //Se guarda en el texto
      guardarP();
      guardarV();
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
      }
    }
    System.out.println("No se ha encontrado la clave.");
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
    System.out.println("4) Existencia");
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
        guardarV();
        break;
      case 4:
        System.out.println("Ingresa el nuevo numero de existencias del producto.");
        t.lineaBlanco();
        int existencia = t.leerEntero();
        producto1.setExistencia(existencia);
        guardarP();
        guardarV();
        break;
      default:
        System.out.println("El numero ingresado no es valido.");
    }
  }

  /**
   * Este metodo es para buscar un producto por nombre.
   *
   * @param nombre del producto a buscar
   */
  public void mostrarPorNombre(String nombre) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      //Aqui se utiliza equals porqe es string
      if (producto1.getNombre().equalsIgnoreCase(nombre)) {
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo muestra un producto por descripcion
   *
   * @param descripcion del producto a buscar
   */
  public void mostrarPorDescripcion(String descripcion) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      if (producto1.getDescripcion().equalsIgnoreCase(descripcion)) {
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo muestra un producto por clave.
   */
  public void mostrarPorClave(int clave) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      if (producto1.getClave() == clave) {
        System.out.println(p1.get(i));
      }
    }
  }

  /**
   * Este metodo ordenara por clave el inventario
   */
  public void ordenarClave() {
    Collections.sort(p1, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        //Se pone asi porque el metodo getClave regresa un primitivo y no hay ningun metodo de compare definido para primitivos
        return Integer.compare(o1.getClave(), o2.getClave());
      }
    });
    imprimirArreglo();
  }

  /**
   * Este metodo ordenara por nombre el inventario
   */
  public void ordenarNombre() {
    Collections.sort(p1, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
      }
    });
    imprimirArreglo();
  }

  /**
   * Este metodo ordenara inventario por precio
   */
  public void ordenarPrecio() {
    Collections.sort(p1, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return Double.compare(o1.getPrecioventa(), o2.getPrecioventa());
      }
    });
    imprimirArreglo();
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
   * Este metodo mostrara el arreglo de ventas
   */
  public void imprimirArregloVenta() {
    cargarV();
    for (int i = 0; i < arrayVenta.size(); i++) {
      cargarV();
      System.out.println(arrayVenta.get(i));
      System.out.println(" Cantidad de productos vendidos:");
      System.out.println(" " + producto1.getVentaProducto());
      System.out.println(" Total de ganancias es: ");
      System.out.println("  " + producto1.getPrecioTotalVendido());
    }
  }

  /**
   * Este metodo eliminara un objeto del array
   *
   * @param clave indicara la clave del objeto a eliminar
   */
  public void eliminarElemento(int clave) {
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      if (producto1.getClave() == clave) {
        p1.remove(i);

        for (int j = 0; j < p1.size(); j++) {
          guardarP();
        }
        System.out.println("El producto ha sido eliminado con exito ");
      }
    }
    imprimirArreglo();
  }

  /**
   * Este metodo registrara la venta de un producto
   *
   * @param clave se introduce la clave del producto que se va a vender
   */
  public void registroVenta(int clave) {
    cargarV();
    for (int i = 0; i < p1.size(); i++) {
      producto1 = p1.get(i);
      if (producto1.getClave() == clave) {
        System.out.println("Introduce la cantidad de productos a vender");
        int cantidad = t.leerEntero();
        if (cantidad <= 0) {
          System.out.println("La cantidad de productos a vender no es válida");
        } else if (cantidad > 0) {
          if (cantidad <= producto1.getExistencia()) {
            System.out.println("Comprobando venta de producto:");
            System.out.println(p1.get(i));
            System.out.println("Presiona 1 para confirmar o 2 para cancelar. ");
            int opcion = t.leerEntero();
            if (opcion == 1) {
              int nuevaExistencia = (producto1.getExistencia() - cantidad);
              producto1.setExistencia(nuevaExistencia);
              //   producto1.setVentaProducto(producto1.getVentaProducto() + cantidad);
              //   double precioTotalVendido = (producto1.getPrecioIVA() * producto1.getVentaProducto());
              //     producto1.setPrecioTotalVendido(precioTotalVendido);
              registroVentaArray(producto1, cantidad);
              guardarP();
              guardarV();
              System.out.println("Venta realizada con exito.");
              System.out.println("Cantidad de productos: " + cantidad+"  "+ producto1.getTipoUnidad());
              System.out.println("El precio con IVA ES: " + producto1.getPrecioIVA());
              System.out.println("El total es:  ");
              System.out.println(producto1.getPrecioIVA() * cantidad);
            }
          } else {
            System.out.println("No hay suficientes productos en existencia.");
          }
        }
      }
    }
  }

  /**
   *
   * Este metodo registra las ventas en el array de ventas
   */
  public void registroVentaArray(Producto p, int cantidad) {
    cargarV();
    cargarP();
    p.setExistencia(p.getExistencia());
    p.setVentaProducto(p.getVentaProducto() + cantidad);
    double precioTotalVendido = (p.getPrecioIVA() * p.getVentaProducto());
    p.setPrecioTotalVendido(precioTotalVendido);
    guardarV();
    System.out.println("Venta: "+ p.getVentaProducto());
    System.out.println("Total: " + p.getPrecioTotalVendido());
    System.out.println("ExistenciaVenta: " + p.getExistencia());
  }

  /**
   * Este metodo es para cargar los datos del array ventas se hizo estatico para evitar problemas de
   * consistencia
   */
  public static void cargarV() {
    arrayVenta = arch.recuperarVenta();
  }

  /**
   * Este metodo es para cargar los datos del array Se hizo estatico porque creaba problemas de
   * arrays vacios y por lo tanto no guardaba nada
   */
  public static void cargarP() {
    p1 = arch.recuperarDatosP();
  }

  /**
   * Este metodo es para guardar los datos del array ventas se hizo estatico para evitar problemas
   * de consistencia
   */
  public static void guardarV() {
    arch.guardarVenta();
  }

  /**
   * Este metodo es guardar los cambios al array Se hizo estatico porque creaba problemas de arrays
   * vacios y por lo tanto no guardaba nada
   */
  public static void guardarP() {
    arch.guardarObjetoP();
  }

}
