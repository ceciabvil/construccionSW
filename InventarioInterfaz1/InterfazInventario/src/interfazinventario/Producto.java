/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.io.*;

/**
 * @author Maria cecilia Aburto Villalobos Version 1.0
 */
public class Producto implements Serializable {

  private String nombre;
  private String descripcion;
  private int clave = 0;
  private double precioCompra;
  private double precioVenta;
  private double precioIVA;
  private String tipoUnidad;
  private int existencia;

  /**
   * Se inicializan las variables de producto
   */
  public Producto() {
    nombre = " ";
    descripcion = " ";
    clave=0;
    precioCompra=0;
    precioVenta=0;
    precioIVA=0;
    tipoUnidad=" ";
    existencia=0;
    
  }

  /**
   * Se inicializan las variables de producto ahora ya con valor
   */
  public Producto(int clave, String nombre, String descripcion, double precioCompra,
      int existencia, String tipoUnidad, double precioVenta, double precioIVA) {
    this.clave = clave;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.existencia = existencia;
    this.tipoUnidad = tipoUnidad;
    this.precioVenta = precioVenta;
    this.precioIVA = precioIVA;
  }
  
  public String getNombre() {
    return nombre;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public int getClave() {
    return clave;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }

  public double getPrecioventa() {
    return precioVenta;
  }

  public int getExistencia() {
    return existencia;
  }

  public double getPrecioIVA() {
    return precioIVA;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public void setPrecioIVA(double precioIVA) {
    this.precioIVA = precioIVA;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }
  
  /**
   * Este metodo permite llamar todos los atributos en una sola funcion. El stringbuilder permite
   * almacenar caracteres de forma indexada (con un orden).
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(55);
    sb.append("\n Clave: ");
    sb.append(this.getClave());
    sb.append("'\n Nombre: ");
    sb.append(this.getNombre());
    sb.append("\n Descripcion: ");
    sb.append(this.getDescripcion());
    sb.append("\n Precio Compra: $ ");
    sb.append(this.getPrecioCompra());
    sb.append("\n Precio Venta: $ ");
    sb.append(this.getPrecioventa());
    sb.append("\n Tipo Unidad: ");
    sb.append(this.getTipoUnidad());
    sb.append("\n Existencia: ");
    sb.append(this.getExistencia());
    return sb.toString();
  }
}
