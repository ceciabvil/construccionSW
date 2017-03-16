/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.interfaz;

/**
 *@version 1.0
 * @author Maria cecilia Aburto Villalobos
 */
public class Venta {
  private int clave;
  private String nombre;
  private String fecha;
  private double precioVenta;
  private double precioIVA;
  private double precioTotal;
  private int totalVendidos;
  
  /**
   * Se inicializan las variables en 0
   */
  public Venta(){
    
  }
  
  /**
   * Se inicializan las variables
   */
  
  public Venta (int clave,String nombre, String fecha, double precioVenta, double precioIVA, double precioTotal, int totalVendidos){
    this.clave=clave;
    this.nombre=nombre;
    this.fecha=fecha;
    this.precioVenta=precioVenta;
    this.precioIVA=precioIVA;
    this.precioTotal=precioTotal;
    this.totalVendidos=totalVendidos;
  }

  public int getClave() {
    return clave;
  }

  public String getNombre() {
    return nombre;
  }

  public String getFecha() {
    return fecha;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public double getPrecioIVA() {
    return precioIVA;
  }

  public double getPrecioTotal() {
    return precioTotal;
  }

  public int getTotalVendidos() {
    return totalVendidos;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public void setPrecioIVA(double precioIVA) {
    this.precioIVA = precioIVA;
  }

  public void setPrecioTotal(double precioTotal) {
    this.precioTotal = precioTotal;
  }

  public void setTotalVendidos(int totalVendidos) {
    this.totalVendidos = totalVendidos;
  }
/**
 * Este metodo manda a llamar a varios atributos de la clase venta para poderlos imprimir en el arreglo inventario 
 * @return 
 */
  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder(55);
    sb.append("\n Clave: ");
    sb.append(this.getClave());
    sb.append("'\n Nombre: ");
    sb.append(this.getNombre());
    sb.append("\n Fecha: ");
    sb.append(this.getFecha());
    sb.append("\n Precio Venta: $ ");
    sb.append(this.getPrecioVenta());
    sb.append("\n Precio IVA: $ ");
    sb.append(this.getPrecioIVA());
    sb.append("\n Total  Vendidos: ");
    sb.append(this.getTotalVendidos());
    sb.append("\n Precio Total: ");
    sb.append(this.getPrecioTotal());
    return sb.toString();
}
  
}
